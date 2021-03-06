/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.repository.i18;

import java.util.List;

import net.sf.gazpachoquest.domain.i18.QuestionnaireDefinitionTranslation;
import net.sf.gazpachoquest.repository.support.GenericRepository;
import net.sf.gazpachoquest.types.Language;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionnaireDefinitionTranslationRepository extends
        GenericRepository<QuestionnaireDefinitionTranslation> {

    @Query("select t from QuestionnaireDefinitionTranslation t where t.language = :language")
    List<QuestionnaireDefinitionTranslation> findByLanguage(@Param("language")
    Language language);
}
