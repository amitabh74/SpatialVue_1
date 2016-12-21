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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rmsi.spatialvue.studio.domain.Unit;

import com.rmsi.spatialvue.studio.service.UnitService;


/**
 * @author Aparesh.Chakraborty
 *
 */
@Controller
public class UnitController {

	@Autowired
	UnitService unitService;
	
	@RequestMapping(value = "/studio/unit/", method = RequestMethod.GET)
	@ResponseBody
    public List<Unit> list(){
		return 	unitService.findAllUnit();	
	}
	
	
	@RequestMapping(value = "/studio/unit/{id}", method = RequestMethod.GET)
	@ResponseBody
    public Unit getUnitById(@PathVariable String id){		
		return 	unitService.findUnitByName(id);	
	}
    	
	
	@RequestMapping(value = "/studio/unit/delete/", method = RequestMethod.GET)
	@ResponseBody
    public void deleteUnit(){
		unitService.deleteUnit();
	}
	
	
	@RequestMapping(value = "/studio/unit/delete/{id}", method = RequestMethod.GET)
	@ResponseBody
    public boolean deleteUnitByname(@PathVariable String id){
		return unitService.deleteUnitByName(id);	
		
	}
	
	@RequestMapping(value = "/studio/unit/create", method = RequestMethod.POST)
	@ResponseBody
    public void createUnit(Unit unit){
		System.out.println(">>>>>>>>>>>>>"+unit.getName()+"-"+unit.getDescription());
		unitService.addUnit(unit);	
	}
	
	@RequestMapping(value = "/studio/unit/edit", method = RequestMethod.POST)
	@ResponseBody
    public void editUnit(Unit unit){
		unitService.updateUnit(unit);	
	}
	
	
}
