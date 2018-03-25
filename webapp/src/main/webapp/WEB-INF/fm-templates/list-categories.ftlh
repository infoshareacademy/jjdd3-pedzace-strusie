<!DOCTYPE html>
<html>
<head>
    <title>Categories list</title>
</head>
<body>
<#list categories>
  <ol>
    <#items as category>
        <li> ${category}</li>
    </#items>
  </ol>
<#else>
  <p>No categories found
</#list>
<#include "footer.ftlh">
</body>
</html>
