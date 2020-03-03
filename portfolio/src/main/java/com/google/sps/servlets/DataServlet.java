// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;


/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/new-comment")
public class DataServlet extends HttpServlet {
  
  /* Container to store comments */
  /*List<String> comments = new ArrayList<String>();*/
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Get input from the form
    String comment = request.getParameter("user-comment");
    /*comments.add(comment);  */

    Entity commentEntity = new Entity("Comment");
    commentEntity.setProperty("comment", comment);

    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    datastore.put(commentEntity);

    // Redirect back to the HTML page
    response.sendRedirect("/index.html");
  }

/** Converts ArrayList object to JSON string **/
  private String convertToJsonUsingGson(ArrayList list) {
    Gson gson = new Gson();
    String json = gson.toJson(list);
    return json;
  }
}


