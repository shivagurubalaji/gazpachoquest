/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.services;

import java.util.List;

import net.sf.gazpachoquest.domain.user.Group;
import net.sf.gazpachoquest.domain.user.User;

public interface GroupService extends PersistenceService<Group> {

    void addUserToGroup(User user, Integer groupId);

    boolean isUserInGroup(Integer userId, Integer groupId);

    List<User> getUsersInGroup(Integer groupId);

    boolean isUserInGroup(Integer userId, String groupName);

}
