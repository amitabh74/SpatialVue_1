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

package com.rmsi.spatialvue.studio.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.BatchSize;


/**
 * The persistent class for the unit database table.
 * 
 */
@Entity
public class Unit implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	//private Integer id;
	private String tenantid;
	private Set<Layer> layers;
	private Set<Project> projects;

    public Unit() {
    }


	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


//	public Integer getId() {
//		return this.id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}


	public String getTenantid() {
		return this.tenantid;
	}

	public void setTenantid(String tenantid) {
		this.tenantid = tenantid;
	}


	//bi-directional many-to-one association to Layer
	@JsonIgnore
	@OneToMany(mappedBy="unitBean", fetch=FetchType.LAZY)
	@BatchSize(size=16)
	public Set<Layer> getLayers() {
		return this.layers;
	}
	@JsonIgnore
	public void setLayers(Set<Layer> layers) {
		this.layers = layers;
	}
	

	//bi-directional many-to-one association to Project
	@JsonIgnore
	@OneToMany(mappedBy="unit", fetch=FetchType.LAZY)
	@BatchSize(size=16)
	public Set<Project> getProjects() {
		return this.projects;
	}
	@JsonIgnore
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}


	
}