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
package net.sf.gazpachoquest.domain.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import net.sf.gazpachoquest.domain.core.embeddables.QuestionnairDefinitionLanguageSettings;
import net.sf.gazpachoquest.domain.i18.QuestionnairDefinitionTranslation;
import net.sf.gazpachoquest.domain.support.AbstractLocalizable;
import net.sf.gazpachoquest.types.EntityStatus;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.MailMessageTemplateType;

@Entity
public class QuestionnairDefinition extends
        AbstractLocalizable<QuestionnairDefinitionTranslation, QuestionnairDefinitionLanguageSettings> {

    private static final long serialVersionUID = 2560468772707058412L;

    @Enumerated(EnumType.STRING)
    private EntityStatus status;

    @Embedded
    private QuestionnairDefinitionLanguageSettings languageSettings;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Language language;

    @OneToMany(mappedBy = "questionnairDefinition", orphanRemoval = true, fetch = FetchType.LAZY)
    private final Set<Questionnair> questionnairs = new HashSet<Questionnair>();

    @OneToMany(mappedBy = "questionnairDefinition", fetch = FetchType.LAZY)
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "language", insertable = false, updatable = false)
    private final Map<Language, QuestionnairDefinitionTranslation> translations = new HashMap<Language, QuestionnairDefinitionTranslation>();

    @OneToMany(mappedBy = "questionnairDefinition", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @OrderColumn(name = "order_in_questionnair")
    private final List<QuestionGroup> questionGroups = new ArrayList<QuestionGroup>();

    @OneToMany(mappedBy = "questionnairDefinition", fetch = FetchType.LAZY)
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "type", insertable = false, updatable = false)
    private final Map<MailMessageTemplateType, MailMessageTemplate> mailTemplates = new HashMap<MailMessageTemplateType, MailMessageTemplate>();

    private Boolean showWelcome;

    private Boolean showProgress;

    private Boolean showGroupInfo;

    private Boolean showNoAnswer;

    private Boolean showQuestionCode;

    public QuestionnairDefinition() {
        super();
    }

    @Override
    public Map<Language, QuestionnairDefinitionTranslation> getTranslations() {
        return Collections.unmodifiableMap(translations);
    }

    public List<QuestionGroup> getQuestionGroups() {
        return Collections.unmodifiableList(questionGroups);
    }

    public void addQuestionGroup(QuestionGroup questionGroup) {
        questionGroups.add(questionGroup);
        questionGroup.setQuestionnairDefinition(this);
    }

    @Override
    public QuestionnairDefinitionLanguageSettings getLanguageSettings() {
        return languageSettings;
    }

    @Override
    public void setLanguageSettings(QuestionnairDefinitionLanguageSettings languageSettings) {
        this.languageSettings = languageSettings;
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public void setLanguage(Language language) {
        this.language = language;
    }

    public EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }

    public Map<MailMessageTemplateType, MailMessageTemplate> getMailTemplates() {
        return Collections.unmodifiableMap(mailTemplates);
    }

    public void addTranslation(Language language, QuestionnairDefinitionTranslation translation) {
        translation.setSurvey(this);
        translations.put(language, translation);
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private EntityStatus status;
        private QuestionnairDefinitionLanguageSettings languageSettings;
        private Language language;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder status(EntityStatus status) {
            this.status = status;
            return this;
        }

        public Builder languageSettings(QuestionnairDefinitionLanguageSettings languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public QuestionnairDefinition build() {
            QuestionnairDefinition questionnairDefinition = new QuestionnairDefinition();
            questionnairDefinition.setId(id);
            questionnairDefinition.status = status;
            questionnairDefinition.languageSettings = languageSettings;
            questionnairDefinition.language = language;
            return questionnairDefinition;
        }
    }
}
