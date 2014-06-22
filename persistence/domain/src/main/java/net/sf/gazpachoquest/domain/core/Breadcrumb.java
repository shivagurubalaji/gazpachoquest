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

import javax.persistence.Basic;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.sf.gazpachoquest.domain.support.AbstractAuditable;

@Entity
@Table(name = "breadcrumb")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Breadcrumb extends AbstractAuditable {

    private static final long serialVersionUID = 8807488300208839486L;

    @ManyToOne(fetch = FetchType.LAZY)
    protected Questionnair questionnair;

    @Basic
    protected Boolean last;

    public Breadcrumb() {
        super();
    }

    public Questionnair getRespondent() {
        return questionnair;
    }

    public void setRespondent(Questionnair questionnair) {
        this.questionnair = questionnair;
    }

    public Boolean isLast() {
        return last;
    }

    public void setLast(Boolean actual) {
        last = actual;
    }

    public static BuilderImpl withProps() {
        return new BuilderImpl();
    }

    public static class BuilderImpl {
        private Integer id;
        private Questionnair questionnair;
        private Boolean last;

        public BuilderImpl questionnair(Questionnair questionnair) {
            this.questionnair = questionnair;
            return this;
        }

        public BuilderImpl id(Integer id) {
            this.id = id;
            return this;
        }

        public BuilderImpl last(Boolean last) {
            this.last = last;
            return this;
        }

        public Breadcrumb build() {
            Breadcrumb breadcrumb = new Breadcrumb();
            breadcrumb.setId(id);
            breadcrumb.questionnair = questionnair;
            breadcrumb.last = last;
            return breadcrumb;
        }
    }
}