<!DOCTYPE html>
<html>
<head>
    <title>Categories list</title>
</head>
<body>
<#list categories>
  <ol>
    <#items as cat>
        <li> ${cat}</li>
    </#items>
  </ol>
<#else>
  <p>No categories found
</#list>
<#include "footer.ftlh">
</body>
</html>