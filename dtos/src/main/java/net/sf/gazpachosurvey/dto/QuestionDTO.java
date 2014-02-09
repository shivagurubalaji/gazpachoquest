package net.sf.gazpachosurvey.dto;

import java.util.ArrayList;
import java.util.List;

import net.sf.gazpachosurvey.dto.answers.AbstractAnswer;
import net.sf.gazpachosurvey.dto.answers.Answer;
import net.sf.gazpachosurvey.dto.support.AbstractIdentifiableDTO;
import net.sf.gazpachosurvey.dto.support.IdentifiableLocalizable;
import net.sf.gazpachosurvey.types.Language;
import net.sf.gazpachosurvey.types.QuestionType;

public class QuestionDTO extends AbstractIdentifiableDTO implements
        IdentifiableLocalizable<QuestionLanguageSettingsDTO> {
    private static final long serialVersionUID = 2663159055152157679L;

    private String code;

    private Boolean isRequired;

    private Language language;

    private QuestionLanguageSettingsDTO languageSettings;

    private List<QuestionOptionDTO> questionOptions;

    private List<QuestionDTO> subquestions;

    private QuestionType type;

    private Answer answer;

    public QuestionDTO() {
        super();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void addQuestionOption(final QuestionOptionDTO questionOption) {
        if (!getQuestionOptions().contains(questionOption)) {
            questionOptions.add(questionOption);
        }
    }

    public void addSubquestion(final QuestionDTO subQuestion) {
        if (!getSubquestions().contains(subQuestion)) {
            subquestions.add(subQuestion);
        }
    }

    public Boolean getIsRequired() {
        return isRequired;
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public QuestionLanguageSettingsDTO getLanguageSettings() {
        if (languageSettings == null) {
            languageSettings = new QuestionLanguageSettingsDTO();
        }
        return languageSettings;
    }

    public List<QuestionOptionDTO> getQuestionOptions() {
        if (questionOptions == null) {
            questionOptions = new ArrayList<>();
        }
        return questionOptions;
    }

    public List<QuestionDTO> getSubquestions() {
        if (subquestions == null) {
            subquestions = new ArrayList<QuestionDTO>();
        }
        return subquestions;
    }

    public QuestionType getType() {
        return type;
    }

    public Boolean isRequired() {
        return isRequired;
    }

    public void setIsRequired(final Boolean isRequired) {
        this.isRequired = isRequired;
    }

    @Override
    public void setLanguage(final Language language) {
        this.language = language;
    }

    @Override
    public void setLanguageSettings(final QuestionLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }

    public void setRequired(final Boolean isRequired) {
        this.isRequired = isRequired;
    }

    public void setType(final QuestionType type) {
        this.type = type;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(AbstractAnswer answer) {
        this.answer = answer;
    }

    public static interface Builder {

        Builder id(Integer id);

        Builder code(String code);

        Builder answers(List<QuestionOptionDTO> answers);

        QuestionDTO build();

        Builder isRequired(Boolean isRequired);

        Builder language(Language language);

        Builder languageSettings(QuestionLanguageSettingsDTO languageSettings);

        QuestionLanguageSettingsDTO.Builder languageSettingsStart();

        Builder subquestions(List<QuestionDTO> subquestions);

        Builder type(QuestionType type);
    }

    public static class BuilderImpl implements Builder {
        private String code;
        private List<QuestionOptionDTO> answers;
        private Integer id;
        private Boolean isRequired;
        private Language language;
        private QuestionLanguageSettingsDTO languageSettings;
        private List<QuestionDTO> subquestions;
        private QuestionType type;

        @Override
        public Builder answers(final List<QuestionOptionDTO> answers) {
            this.answers = answers;
            return this;
        }

        @Override
        public QuestionDTO build() {
            QuestionDTO questionDTO = new QuestionDTO();
            questionDTO.setId(id);
            questionDTO.code = code;
            questionDTO.isRequired = isRequired;
            questionDTO.type = type;
            questionDTO.language = language;
            questionDTO.subquestions = subquestions;
            questionDTO.questionOptions = answers;
            questionDTO.languageSettings = languageSettings;
            return questionDTO;
        }

        @Override
        public Builder id(final Integer id) {
            this.id = id;
            return this;
        }

        @Override
        public Builder isRequired(final Boolean isRequired) {
            this.isRequired = isRequired;
            return this;
        }

        @Override
        public Builder language(final Language language) {
            this.language = language;
            return this;
        }

        @Override
        public Builder languageSettings(final QuestionLanguageSettingsDTO languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        @Override
        public QuestionLanguageSettingsDTO.Builder languageSettingsStart() {
            return QuestionLanguageSettingsDTO.languageSettingsStart(this);
        }

        @Override
        public Builder subquestions(final List<QuestionDTO> subquestions) {
            this.subquestions = subquestions;
            return this;
        }

        @Override
        public Builder type(final QuestionType type) {
            this.type = type;
            return this;
        }

        @Override
        public Builder code(String code) {
            this.code = code;
            return this;
        }
    }

    public static Builder with() {
        return new BuilderImpl();
    }

}
