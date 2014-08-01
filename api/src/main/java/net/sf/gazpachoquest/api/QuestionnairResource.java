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
package net.sf.gazpachoquest.api;

import java.io.Serializable;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import net.sf.gazpachoquest.dto.QuestionnairPageDTO;
import net.sf.gazpachoquest.dto.QuestionnairDTO;
import net.sf.gazpachoquest.dto.answers.Answer;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.NavigationAction;
import net.sf.gazpachoquest.types.RenderingMode;

@Path("/questionnairs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface QuestionnairResource extends Serializable {

    @GET
    @Path("/{questionnairId}")
    QuestionnairDTO getDefinition(@PathParam("questionnairId")
    Integer questionnairId);

    @GET
    @Path("/{questionnairId}/page")
    QuestionnairPageDTO getPage(@PathParam("questionnairId")
    Integer questionnairId, @QueryParam("mode")
    RenderingMode mode, @QueryParam("preferredLanguage")
    Language language, @QueryParam("action")
    NavigationAction action);

    @POST
    @Path("/{questionnairId}/answer")
    void saveAnswer(Answer answer, @PathParam("questionnairId")
    Integer questionnairId, @QueryParam("questionCode")
    String questionCode);
}
