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

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("Q")
public class QuestionBreadcrumb extends Breadcrumb {

    private static final long serialVersionUID = 4401342736300174568L;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Breadcrumb parent;

    public QuestionBreadcrumb() {
        super();
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;

        private Question question;

        private Questionnair questionnair;

        private Boolean last;

        public Builder last(Boolean last) {
            this.last = last;
            return this;
        }

        public Builder questionnair(Questionnair questionnair) {
            this.questionnair = questionnair;
            return this;
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder question(Question question) {
            this.question = question;
            return this;
        }

        public QuestionBreadcrumb build() {
            QuestionBreadcrumb questionBreadcrumb = new QuestionBreadcrumb();
            questionBreadcrumb.question = question;
            questionBreadcrumb.questionnair = questionnair;
            questionBreadcrumb.last = last;
            questionBreadcrumb.setId(id);
            return questionBreadcrumb;
        }
    }
}