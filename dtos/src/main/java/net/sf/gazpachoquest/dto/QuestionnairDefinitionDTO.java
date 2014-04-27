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
package net.sf.gazpachoquest.dto;

import java.util.ArrayList;
import java.util.List;

import net.sf.gazpachoquest.dto.support.AbstractAuditableDTO;
import net.sf.gazpachoquest.dto.support.IdentifiableLocalizable;
import net.sf.gazpachoquest.types.Language;

public class QuestionnairDefinitionDTO extends AbstractAuditableDTO implements
        IdentifiableLocalizable<QuestionnairDefinitionLanguageSettingsDTO> {

    private static final long serialVersionUID = 4558625807621395019L;

    private Language language;

    private QuestionnairDefinitionLanguageSettingsDTO languageSettings;

    private List<QuestionGroupDTO> questionGroups;

    public QuestionnairDefinitionDTO() {
        super();
    }

    public void addQuestionGroup(final QuestionGroupDTO questionGroup) {
        getQuestionGroups().add(questionGroup);
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public QuestionnairDefinitionLanguageSettingsDTO getLanguageSettings() {
        return languageSettings;
    }

    public QuestionGroupDTO getLastQuestionGroupDTO() {
        int count = getQuestionGroups().size();
        return count > 0 ? questionGroups.get(count - 1) : null;
    }

    public List<QuestionGroupDTO> getQuestionGroups() {
        if (questionGroups == null) {
            questionGroups = new ArrayList<>();
        }
        return questionGroups;
    }

    @Override
    public void setLanguage(final Language language) {
        this.language = language;
    }

    @Override
    public void setLanguageSettings(final QuestionnairDefinitionLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }

    public void setQuestionGroups(final List<QuestionGroupDTO> questionGroups) {
        this.questionGroups = questionGroups;
    }

    public static Builder with() {
        return new BuilderImpl();
    }

    public static interface Builder {
        QuestionnairDefinitionDTO build();

        Builder id(Integer id);

        Builder language(Language language);

        Builder languageSettings(QuestionnairDefinitionLanguageSettingsDTO languageSettings);

        QuestionnairDefinitionLanguageSettingsDTO.Builder questionnairLanguageSettingsStart();
    }

    public static class BuilderImpl implements Builder {
        private Integer id;

        private Language language;

        private QuestionnairDefinitionLanguageSettingsDTO languageSettings;

        @Override
        public QuestionnairDefinitionDTO build() {
            QuestionnairDefinitionDTO questionnairDefinitionDTO = new QuestionnairDefinitionDTO();
            questionnairDefinitionDTO.languageSettings = languageSettings;
            questionnairDefinitionDTO.language = language;
            questionnairDefinitionDTO.setId(id);
            return questionnairDefinitionDTO;
        }

        @Override
        public Builder id(final Integer id) {
            this.id = id;
            return this;
        }

        @Override
        public BuilderImpl language(final Language language) {
            this.language = language;
            return this;
        }

        @Override
        public BuilderImpl languageSettings(final QuestionnairDefinitionLanguageSettingsDTO languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        @Override
        public QuestionnairDefinitionLanguageSettingsDTO.Builder questionnairLanguageSettingsStart() {
            return QuestionnairDefinitionLanguageSettingsDTO.surveyLanguageSettingsStart(this);
        }
    }

}
