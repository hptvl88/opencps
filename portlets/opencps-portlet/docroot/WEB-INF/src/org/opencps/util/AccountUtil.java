/**
* OpenCPS is the open source Core Public Services software
* Copyright (C) 2016-present OpenCPS community

* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU Affero General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* any later version.

* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU Affero General Public License for more details.
* You should have received a copy of the GNU Affero General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>
*/

package org.opencps.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.opencps.dossiermgt.bean.AccountBean;

import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Role;
import com.liferay.portlet.documentlibrary.model.DLFolder;

/**
 * @author trungnt
 */
public class AccountUtil {

	public static void initAccount(
	    Object accountInstance, String accountType, DLFolder accountFolder,
	    List<Role> accountRoles, List<Organization> accountOrgs,
	    long ownerUserId, long ownerOrganizationId) {

		AccountBean accountBean = new AccountBean(
		    accountInstance, accountType, accountFolder, accountRoles,
		    accountOrgs, ownerUserId, ownerOrganizationId);
		setAccountBean(accountBean);
	}
	
	public static void destroy(HttpServletRequest request){
		
		setAccountBean(null);
		HttpSession session = request.getSession();
		session.removeAttribute(WebKeys.ACCOUNT_FOLDER);
		session.removeAttribute(WebKeys.ACCOUNT_TYPE);
		session.removeAttribute(WebKeys.ACCOUNT_ORGANIZATION);
		session.removeAttribute(WebKeys.ACCOUNT_OWNERORGANIZATIONID);
		session.removeAttribute(WebKeys.ACCOUNT_OWNERUSERID);
		session.removeAttribute(WebKeys.ACCOUNT_ROLES);
		session.removeAttribute(WebKeys.CITIZEN_ENTRY);
		session.removeAttribute(WebKeys.BUSINESS_ENTRY);
		session.removeAttribute(WebKeys.EMPLOYEE_ENTRY);
		
		request.removeAttribute(WebKeys.ACCOUNT_FOLDER);
		request.removeAttribute(WebKeys.ACCOUNT_TYPE);
		request.removeAttribute(WebKeys.ACCOUNT_ORGANIZATION);
		request.removeAttribute(WebKeys.ACCOUNT_OWNERORGANIZATIONID);
		request.removeAttribute(WebKeys.ACCOUNT_OWNERUSERID);
		request.removeAttribute(WebKeys.ACCOUNT_ROLES);
		request.removeAttribute(WebKeys.CITIZEN_ENTRY);
		request.removeAttribute(WebKeys.BUSINESS_ENTRY);
		request.removeAttribute(WebKeys.EMPLOYEE_ENTRY);
		
		if (session != null) {
		    session.invalidate();
		}
		
		//System.gc();
	}
	
	public static void destroy(HttpServletRequest request, boolean sessionInvalidate){
		
		setAccountBean(null);
		HttpSession session = request.getSession();
		session.removeAttribute(WebKeys.ACCOUNT_FOLDER);
		session.removeAttribute(WebKeys.ACCOUNT_TYPE);
		session.removeAttribute(WebKeys.ACCOUNT_ORGANIZATION);
		session.removeAttribute(WebKeys.ACCOUNT_OWNERORGANIZATIONID);
		session.removeAttribute(WebKeys.ACCOUNT_OWNERUSERID);
		session.removeAttribute(WebKeys.ACCOUNT_ROLES);
		session.removeAttribute(WebKeys.CITIZEN_ENTRY);
		session.removeAttribute(WebKeys.BUSINESS_ENTRY);
		session.removeAttribute(WebKeys.EMPLOYEE_ENTRY);
		
		request.removeAttribute(WebKeys.ACCOUNT_FOLDER);
		request.removeAttribute(WebKeys.ACCOUNT_TYPE);
		request.removeAttribute(WebKeys.ACCOUNT_ORGANIZATION);
		request.removeAttribute(WebKeys.ACCOUNT_OWNERORGANIZATIONID);
		request.removeAttribute(WebKeys.ACCOUNT_OWNERUSERID);
		request.removeAttribute(WebKeys.ACCOUNT_ROLES);
		request.removeAttribute(WebKeys.CITIZEN_ENTRY);
		request.removeAttribute(WebKeys.BUSINESS_ENTRY);
		request.removeAttribute(WebKeys.EMPLOYEE_ENTRY);
		
		if (session != null && sessionInvalidate) {
		    session.invalidate();
		}
		
		//System.gc();
	}

	private static AccountBean _accountBean;

	public static void setAccountBean(AccountBean accountBean) {

		_accountBean = accountBean;
	}

	public static AccountBean getAccountBean() {

		return _accountBean;
	}

}
