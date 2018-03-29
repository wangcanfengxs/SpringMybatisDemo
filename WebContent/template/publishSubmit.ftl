<!DOCTYPE html>
<html>
<#include "/include/head.ftl">
<body>
<#include "/include/support.ftl">
<#include "/include/header.ftl">
<div class="g-doc">
    <#if product??>
    <div class="n-result">
        <h3>发布成功！</h3>
        <p><a href="/show?productId=${product.productId}">[查看内容]</a><a href="/">[返回首页]</a></p>
    </div>
    <#else>
    <div class="n-result">
        <h3>发布失败！</h3>
        <p><a href="/publish">[重新发布]</a><a href="/">[返回首页]</a></p>
    </div>
    </#if>
</div>
<#include "/include/footer.ftl">
</body>
</html>