/* ----------------------------------------------------------------------
 * Copyright (c) 2011 by RMSI.
 * All Rights Reserved
 *
 * Permission to use this program and its related files is at the
 * discretion of RMSI Pvt Ltd.
 *
 * The licensee of RMSI Software agrees that:
 *    - Redistribution in whole or in part is not permitted.
 *    - Modification of source is not permitted.
 *    - Use of the source in whole or in part outside of RMSI is not
 *      permitted.
 *
 * THIS SOFTWARE IS PROVIDED ''AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL RMSI OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 * ----------------------------------------------------------------------
 */

package com.rmsi.spatialvue.studio.web.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rmsi.spatialvue.studio.domain.Layer;
import com.rmsi.spatialvue.studio.domain.Project;
import com.rmsi.spatialvue.studio.domain.Savedquery;
import com.rmsi.spatialvue.studio.domain.User;
import com.rmsi.spatialvue.studio.service.LayerService;
import com.rmsi.spatialvue.studio.service.ProjectService;
import com.rmsi.spatialvue.studio.service.SavedqueryService;
import com.rmsi.spatialvue.studio.service.UserService;

/**
 * @author Aparesh.Chakraborty
 *
 */
@Controller
public class SavedqueryController {

	@Autowired
	SavedqueryService savedqueryService;
	@Autowired
	ProjectService projectService;
	@Autowired
	LayerService layerService;
	
	@RequestMapping(value = "/studio/savedquery/", method = RequestMethod.GET)
	@ResponseBody
    public List<Savedquery> list(){
		return 	savedqueryService.findAllSavedquery();	
	}
	
	
	@RequestMapping(value = "/studio/savedquery/{id}", method = RequestMethod.GET)
	@ResponseBody
    public Savedquery getSavedqueryById(@PathVariable String id){		
		return 	savedqueryService.findSavedqueryByName(id);	
	}
    	
	
	@RequestMapping(value = "/studio/savedquery/delete/", method = RequestMethod.GET)
	@ResponseBody
    public void deleteSavedquery(){
		savedqueryService.deleteSavedquery();
	}
	
	
	@RequestMapping(value = "/studio/savedquery/delete/{id}", method = RequestMethod.GET)
	@ResponseBody
    public void deleteSavedqueryById(@PathVariable Long id){
		savedqueryService.deleteSavedqueryById(id);	
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/studio/savedquery/create", method = RequestMethod.POST)
	@ResponseBody
    public Savedquery create(HttpServletRequest request){
			
		Savedquery savedquery = new Savedquery();
		try{
			Savedquery existingQuery = savedqueryService.findSavedqueryByName(ServletRequestUtils.getRequiredStringParameter(request, "Name"));
			
			System.out.println("---Printing paarams");
			java.util.Enumeration<String> enm = request.getParameterNames();
			while(enm.hasMoreElements()){
				String elm = enm.nextElement();
				String value = (String)request.getParameter(elm);
				System.out.println(elm + " ----> " + value);
			}
			
			if(existingQuery == null){
				System.out.println("---Query name doesn't exists");
				savedquery.setName(ServletRequestUtils.getRequiredStringParameter(request, "Name"));
				savedquery.setDescription(ServletRequestUtils.getRequiredStringParameter(request, "Description"));
				savedquery.setWhereexpression(ServletRequestUtils.getRequiredStringParameter(request, "WhereExpression"));
				
				String project = ServletRequestUtils.getStringParameter(request, "Project");
				//System.out.println("----Project Bean Name: " + project);
				Project projectBean = projectService.findProjectByName(project);
				savedquery.setProjectBean(projectBean);
				
				String layerAlias = ServletRequestUtils.getStringParameter(request, "Layer");
				//System.out.println("------Layer Bean name: " + layerAlias);
				Layer layerBean = layerService.findLayerByName(layerAlias);
				savedquery.setLayerBean(layerBean);
				
				return savedqueryService.addSavedquery(savedquery);
			}else{
				System.out.println("Name exists: " + existingQuery.getName());
				return null;
			}
			
		}catch(ServletRequestBindingException sre){
			sre.printStackTrace();
			return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/studio/savedquery/edit", method = RequestMethod.POST)
	@ResponseBody
    public Savedquery editSavedquery(HttpServletRequest request){
		//savedqueryService.updateSavedquery(Savedquery);
		try{
			String name = ServletRequestUtils.getRequiredStringParameter(request, "Name");
			//System.out.println("----- Saved Query Name: " + name);
			Savedquery savedQuery = savedqueryService.findSavedqueryByName(name);
			
			savedQuery.setDescription(ServletRequestUtils.getRequiredStringParameter(request, "Description"));
			savedQuery.setWhereexpression(ServletRequestUtils.getRequiredStringParameter(request, "WhereExpression"));
			
			String project = ServletRequestUtils.getStringParameter(request, "Project");
			//System.out.println("----Project Bean Name: " + project);
			Project projectBean = projectService.findProjectByName(project);
			savedQuery.setProjectBean(projectBean);
			
			String layerAlias = ServletRequestUtils.getStringParameter(request, "Layer");
			//System.out.println("------Layer Bean Name: " + layerAlias);
			Layer layerBean = layerService.findLayerByName(layerAlias);
			savedQuery.setLayerBean(layerBean);
			return savedqueryService.updateSavedquery(savedQuery);
			
		}catch(ServletRequestBindingException sre){
			sre.printStackTrace();
			return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/studio/savedquery/names/{project}/{layer}", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getQueryNames(@PathVariable String project, @PathVariable String layer){
		return savedqueryService.getSavedQueryNames(project, layer);
	}
	
	@RequestMapping(value="/studio/savedquery/queryexpression/{queryName}", method = RequestMethod.GET)
	@ResponseBody
	public String getQueryExpression(@PathVariable String queryName){
		List<String> lstExprs = savedqueryService.getQueryExpression(queryName);
		if(lstExprs.size() > 0){
			return lstExprs.get(0);
		}else{
			return null;
		}
	}
	
	@RequestMapping(value="/studio/savedquery/description/{queryName}", method = RequestMethod.GET)
	@ResponseBody
	public String queryDescription(@PathVariable String queryName){
		return savedqueryService.getQueryDescriptionByQueryName(queryName);
	}
	
}
