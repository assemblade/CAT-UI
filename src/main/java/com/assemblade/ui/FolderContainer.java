/*
 * Copyright 2013 Mike Adamson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.assemblade.ui;

import com.assemblade.client.CallFailedException;
import com.assemblade.client.ChangePasswordException;
import com.assemblade.client.ClientException;
import com.assemblade.client.Folders;
import com.assemblade.client.Login;
import com.assemblade.client.model.Authentication;
import com.assemblade.client.model.Folder;
import com.vaadin.data.util.BeanItemContainer;

import java.util.List;

public class FolderContainer extends BeanItemContainer<Folder> {
    public FolderContainer() throws IllegalArgumentException {
        super(Folder.class);
        Login login = new Login("http://localhost:20080/cat-rest-api");
        try {
            Authentication authentication = login.login("admin", "Mikado1");

            Folders folders = new Folders(authentication);

            addAll(folders.getRootFolders());
        } catch (ChangePasswordException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (CallFailedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClientException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }
}
