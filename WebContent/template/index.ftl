<!DOCTYPE html>
<html>
<#include "/include/head.ftl">
<body>
<#include "/include/support.ftl">
<#include "/include/header.ftl">
<#assign listType = RequestParameters['type']!"0">
<div class="g-doc">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <div class="tab">
            <ul>
            	<#-- 当listType不为空，或者不等于1的时候，显示所有内容, listType等于1表示显示未购买内容-->
                <li <#if !listType?? || listType != "1">class="z-sel"</#if> ><a href="/">所有内容</a></li>
                <#if user?? && user.userRole == 0><li <#if listType == "1">class="z-sel"</#if> ><a href="/?type=1">未购买的内容</a></li></#if>
            </ul>
        </div>
    </div>
    <#if !productList?? || !productList?has_content>
    <div class="n-result">
        <h3>暂无内容！</h3>
    </div>
    <#else>
    <div class="n-plist">
        <ul class="f-cb" id="plist">
        <#-- 显示未购买内容 -->
        <#if user?? && user.userRole == 0 && listType == "1">
            <#list productList as x>
                <#if !x.buy>
                <li id="p-${x.productId}">
                    <a href="/show?productId=${x.productId}" class="link">
                        <div class="img"><img src="${x.image}" alt="${x.title}"></div>
                        <h3>${x.title}</h3>
                        <div class="price"><span class="v-unit">¥</span><span class="v-value">${x.price}</span></div>
                    </a>
                </li>
                </#if>
            </#list>
        <#else>
        <#-- 显示所有内容 -->
            <#list productList as x>
                <li id="p-${x.productId}">
                    <a href="/show?productId=${x.productId}" class="link">
                        <div class="img"><img src="${x.image}" alt="${x.title}"></div>
                        <h3>${x.title}</h3>
                        <div class="price"><span class="v-unit">¥</span><span class="v-value">${x.price}</span></div>
                        <#if user?? && user.userRole==0 && x.buy == true><span class="had"><b>已购买</b></span></#if>
                        <#if user?? && user.userRole==1 && x.sellCount gt 0 ><span class="had"><b>已售出${x.sellCount}</b></span></#if>
                    </a>
                    <#if user?? && user.userRole==1 && x.sellCount == 0><span class="u-btn u-btn-normal u-btn-xs del" data-del="${x.productId}">删除</span></#if>
                </li>
            </#list>
        </#if>
        </ul>
    </div>
    </#if>
</div>
<#include "/include/footer.ftl">
<script type="text/javascript" src="/js/global.js"></script>
<script type="text/javascript" src="/js/pageIndex.js"></script>
</body>
</html>