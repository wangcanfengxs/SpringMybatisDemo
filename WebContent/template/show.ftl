<!DOCTYPE html>
<html>
<#include "/include/head.ftl">
<body>
<#include "/include/support.ftl">
<#include "/include/header.ftl">
<div class="g-doc">
    <#if !product??>
    <div class="n-result">
        <h3>内容不存在！</h3>
    </div>
    <#else>
    <div class="n-show f-cb" id="showContent">
        <div class="img"><img src="${product.image}" alt=""></div>
        <div class="cnt">
            <h2>${product.title}</h2>
            <p class="summary">${product.digest}</p>
            <div class="price">
                <span class="v-unit">价格 ¥</span><span class="v-value">${product.price}</span>
            </div>
            
            <#if user?? && user.userRole==0>
                	
                    <#if orderPrice??>
                    	<div class="num">购买数量：<span class="totalNum" id="allNum">${orderCount}</span></div>
                    <#else>
                    	<div class="num">购买数量：<span id="plusNum" class="lessNum"><a>-</a></span><span class="totalNum" id="allNum">1</span><span id="addNum" class="moreNum"><a>+</a></span></div>
                    </#if>
                </#if>
   
            <div class="oprt f-cb">
            	<#--如果用户存在，且为买家-->
                <#if user?? && user.userRole==0>
                	
                    <#if orderPrice??>
                    	<span class="u-btn u-btn-primary z-dis">已购买</span>
                    	<span class="buyprice">当时购买价格：¥${orderPrice}</span>
                    <#else>
                    	<button class="u-btn u-btn-primary" id="add" data-id="${product.productId}" data-title="${product.title}" data-price="${product.price}">加入购物车</button>
                    </#if>
                </#if>
                
                <#--如果用户存在，且为卖家-->
                <#if user?? && user.userRole==1>
                	<a href="/edit?productId=${product.productId}" class="u-btn u-btn-primary">编 辑</a>
                </#if>
            </div>
        </div>
    </div>
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>详细信息</h2>
    </div>
    <div class="n-detail">
        ${product.detail}
    </div>
    </#if>
</div>
<#include "/include/footer.ftl">
<script type="text/javascript" src="/js/global.js"></script>
<script type="text/javascript" src="/js/pageShow.js"></script>
</body>
</html>