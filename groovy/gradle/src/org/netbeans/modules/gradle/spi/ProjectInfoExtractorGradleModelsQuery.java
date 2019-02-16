/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.gradle.spi;

import java.util.Set;
import org.openide.util.Lookup;

/**
 * Query to allow ProjectInfoExtractor to retreive Models from Gradle and inject
 * project properties to Gradle command line
 * 
 * Call hierarchy:
 * ProjectInfoExtractor.fallback()
 * ProjectInfoExtractorGradleModelsQuery.isSupported()
 * ProjectInfoExtractorGradleModelsQuery.getRequestedModels()
 * ProjectInfoExtractorGradleModelsQuery.isSupported()
 * ProjectInfoExtractorGradleModelsQuery.modelsLoaded()
 * ProjectInfoExtractor.extract()
 *
 * @author arsi
 */
public interface ProjectInfoExtractorGradleModelsQuery {

    /**
     * Get models wanted by this Gradle extension
     * @return 
     */
    public Class[] getRequestedModels();

    /**
     * Requested models loaded
     * @param lookup 
     */
    public void modelsLoaded(Lookup lookup);

    /**
     * supports this extension this Project?
     * @return 
     */
    public boolean isSupported();

    /**
     * Get project properies to inject to Gradle commandline
     * @return 
     */
    public GradleProjectProperty[] getExtraGradleProjectProperties();

}
