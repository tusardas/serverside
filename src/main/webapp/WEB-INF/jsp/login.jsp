<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
    <head>
        <title>Please Login</title>
    </head>
    <body>
        <div>
            <form action="/login" method="post">               
                <fieldset>
                    <legend>Please Login</legend>
                    <c:if test="${param.error != null}">
                        <div>    
                            Invalid username and password.
                        </div>
                    </c:if>
                    <c:if test="${param.logout != null}">
                        <div> 
                            You have been logged out.
                        </div>
                    </c:if>
                    <label for="username">Username</label>
                    <input type="text" id="username" name="username"/>        
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password"/>    
                    <div class="form-actions">
                        <button type="submit" class="btn">Log in</button>
                    </div>
                </fieldset>
            </form>
        </div>
    </body>
</html>