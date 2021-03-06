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
package net.sf.gazpachoquest.facades;

import net.sf.gazpachoquest.dto.LabelDTO;
import net.sf.gazpachoquest.dto.LabelLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.LabelSetDTO;
import net.sf.gazpachoquest.dto.QuestionDTO;
import net.sf.gazpachoquest.dto.SectionDTO;
import net.sf.gazpachoquest.dto.QuestionOptionDTO;
import net.sf.gazpachoquest.dto.QuestionnaireDefinitionDTO;
import net.sf.gazpachoquest.dto.embeddables.QuestionLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.embeddables.QuestionOptionLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.embeddables.QuestionnaireDefinitionLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.embeddables.SectionLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.support.TranslationDTO;

public interface QuestionnaireDefinitionEditorFacade {

    void confirm(QuestionnaireDefinitionDTO questionaireDefinition);

    LabelDTO save(LabelDTO label);

    LabelSetDTO save(LabelSetDTO labelSet);

    QuestionDTO save(QuestionDTO question);

    SectionDTO save(SectionDTO section);

    QuestionOptionDTO save(QuestionOptionDTO questionOption);

    QuestionnaireDefinitionDTO save(QuestionnaireDefinitionDTO questionaireDefinition);

    TranslationDTO<LabelDTO, LabelLanguageSettingsDTO> saveLabelTranslation(
            TranslationDTO<LabelDTO, LabelLanguageSettingsDTO> translation);

    TranslationDTO<SectionDTO, SectionLanguageSettingsDTO> saveSectionTranslation(
            TranslationDTO<SectionDTO, SectionLanguageSettingsDTO> translation);

    TranslationDTO<QuestionOptionDTO, QuestionOptionLanguageSettingsDTO> saveQuestionOptionTranslation(
            TranslationDTO<QuestionOptionDTO, QuestionOptionLanguageSettingsDTO> translation);

    TranslationDTO<QuestionDTO, QuestionLanguageSettingsDTO> saveQuestionTranslation(
            TranslationDTO<QuestionDTO, QuestionLanguageSettingsDTO> translation);

    TranslationDTO<QuestionnaireDefinitionDTO, QuestionnaireDefinitionLanguageSettingsDTO> saveQuestionnaireTranslation(
            TranslationDTO<QuestionnaireDefinitionDTO, QuestionnaireDefinitionLanguageSettingsDTO> translation);

}
