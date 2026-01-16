
// Description: Java JPA Factory interface for ISOLang.

/*
 *	io.github.msobkow.CFSec
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal 3.1 CFSec - Security Services
 *	
 *	This file is part of Mark's Code Fractal CFSec.
 *	
 *	Mark's Code Fractal CFSec is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU Library General Public License,
 *	Version 3 or later.
 *	
 *	Mark's Code Fractal CFSec is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU Library General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Mark's Code Fractal CFSec is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU Library General Public License
 *	along with Mark's Code Fractal CFSec.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes in order to
 *	tie it to proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 *	
 */

package io.github.msobkow.v3_1.cfsec.cfsec;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import io.github.msobkow.v3_1.cflib.*;
import io.github.msobkow.v3_1.cflib.dbutil.*;

/*
 *	ICFSecISOLangFactory interface for ISOLang
 */
public interface ICFSecISOLangFactory
{

	/**
	 *	Allocate a primary history key for ISOLang instances.
	 *
	 *	@return	The new instance.
	 */
	ICFSecISOLangHPKey newHPKey();

	/**
	 *	Allocate a Code3Idx key over ISOLang instances.
	 *
	 *	@return	The new instance.
	 */
	public ICFSecISOLangByCode3IdxKey newByCode3IdxKey();

	/**
	 *	Allocate a Code2Idx key over ISOLang instances.
	 *
	 *	@return	The new instance.
	 */
	public ICFSecISOLangByCode2IdxKey newByCode2IdxKey();

	/**
	 *	Allocate a ISOLang interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ICFSecISOLang newRec();

	/**
	 *	Allocate a ISOLang history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public ICFSecISOLangH newHRec();

}
