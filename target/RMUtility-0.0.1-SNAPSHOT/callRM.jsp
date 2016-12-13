<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>MRS / QS Utility</title>
      <link rel="stylesheet" href="main.css" />
      <link rel="stylesheet" href="bootstrap.css" />
      <script type="text/javascript" src="main.js"></script>
   </head>
   <body>
      <div class="mainWrapper">
         <div class="headerWrapper">
            <div class="logoWrapper">
               <img src="./img/logo.png" />
            </div>
         </div>
         
          <form action="MRSAndEJBHandler" method="post" enctype="multipart/form-data">
         <div class="formContentWrapper">
            <h1>CallRM via</h1>
            <div class="inputGroups">
               <div class="makingCenter">
                  <div class="centerGroup">
                     <div class="input-group">
                        <span class="input-group-addon">
                        <input type="radio" name="requestType" value="MRS" class="mrsrequest" onchange="displayContent(mrsrequest)">
                        </span>
                        <input type="text" class="form-control" value="MRS Request" readonly="true">
                     </div>
                  </div>
                  <div class="centerGroup">
                     <div class="input-group">
                        <span class="input-group-addon">
                        <input type="radio" name="requestType" value="QS" class="queryservice" onchange="displayContent(queryservice)">
                        </span>
                        <input type="text" class="form-control" value="Query Service" readonly="true">
                     </div>
                  </div>
               </div>
            </div>
            <div class="environmentGroup form-group">
               <label>Environment:</label>
               <select class="form-control" name="environment" id="environment"
                  onchange="clearError(this, 'envError')" required>
                  <option value="">Please Select</option>
                  <option value="ST11">ST11</option>
                  <option value="ST13">ST13</option>
                  <option value="ST15">ST15</option>
               </select>
               <div id="envError" style="color: red"></div>
            </div>
            <div id="mrsrequest" class="maincontent">
               <h3>Upload MRS Request XML:</h3>
               <div class="makingCenter">
                  <div class="input-group">
                     <div class="fileinput fileinput-new">
                        <input type="file" name="mrsRequestFile" size="40" id="requestFile"
                           onchange="validateFileExtension(this.value);" required/>
                     </div>
                  </div>
                  <div id="fileTypeError" style="color: red"></div>
               </div>
               <input type="submit" class="btn btn-primary" value="Submit Request" />
            </div>
            <div id="queryservice" class="maincontent">
				<h3>Request params for EJB call</h3>
            </div>
         </div>
      </form>
      </div>
     
   </body>
</html>