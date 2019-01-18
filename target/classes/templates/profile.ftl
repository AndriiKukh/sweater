<#import "parts/common.ftl" as c>
<@c.page>
    <p>Profile page</p>
    <h5>${username}</h5>
    ${message!}
    <form method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Password </label>
            <div class="col-sm-6">
                <input type="text" name="password" class="form-control" placeholder="Password"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Email address </label>
            <div class="col-sm-6">
                <input type="text" name="email" class="form-control" placeholder="youremail@some.com" value="${email!''}"/>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</@c.page>