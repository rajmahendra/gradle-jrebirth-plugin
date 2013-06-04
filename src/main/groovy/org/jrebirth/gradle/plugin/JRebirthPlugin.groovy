/**
 * Get more info at : www.jrebirth.org .
 * Copyright JRebirth.org © 2011-2013
 * Contact : sebastien.bordes@jrebirth.org
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributers
 * @author Rajmahendra Hegde <rajmahendra@gmail.com>
 */
package org.jrebirth.gradle.plugin


import groovy.io.FileType;

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.ConfigurationContainer
import org.gradle.api.artifacts.ExternalModuleDependency
import org.gradle.api.execution.TaskExecutionGraph
import org.gradle.api.internal.artifacts.dependencies.DefaultExternalModuleDependency
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.plugins.WarPlugin
import org.gradle.api.tasks.Exec;
import org.gradle.api.tasks.JavaExec;
import org.gradle.api.tasks.SourceSet
import org.gradle.api.tasks.bundling.Jar
import org.gradle.api.tasks.bundling.War
import org.gradle.api.tasks.StopExecutionException
import org.gradle.api.tasks.testing.Test
import org.gradle.api.internal.project.ProjectInternal

/** 
 * <p>Primary class for JRebirth Gradle Plugin</p>
 * 
 * @author Rajmahendra Hegde <rajmahendra@gmail.com>
 *
 *
 */
class JRebirthPlugin implements Plugin<Project> {

	void apply(Project project) {
	
		project.extensions.create("jrebirth", JRebirthPluginExtension)
		
		project.getPlugins().apply(JavaPlugin.class);
		
		
			project.repositories {
					mavenRepo(name:"JRebirth Repo", url:"http://repo.jrebirth.org/jrebirth-release-local/")
			}
			
			project.configurations { providedCompile }

		project.dependencies { 
			compile "org.jrebirth:core:0.7.3" 
			providedCompile project.files("${System.properties['java.home']}/lib/jfxrt.jar")
		}
		
		println ("JR version : " + project.jrebirth.jrebirthVersion)
		
		project.sourceSets.main.compileClasspath += project.configurations.providedCompile
		
		
	}

}




