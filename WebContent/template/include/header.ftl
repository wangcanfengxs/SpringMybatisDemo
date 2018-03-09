<div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
        <#if user>
            <#if user.userRole==1>卖家<#else>买家</#if>你好，<span class="name">${user.userName}</span>！<a href="/logout">[退出]</a>
        <#else>
            请<a href="/login">[登录]</a>
        </#if>
        </div>
        <ul class="nav">
            <li><a href="/">首页</a></li>
            <#if user && user.userRole==0>
            <li><a href="/account">账务</a></li>
            </#if>
            <#if user && user.userRole==1>
            <li><a href="/public">发布</a></li>
            </#if>
        </ul>
    </div>
</div>