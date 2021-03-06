<#import "parts/common.ftl" as c>

<@c.page>
    <div class="form-row mt-3">
        <div class="form-group col-md-6">
            <form method="get" action="/main" class="form-inline">
                <input type="text" name="filter" class="form-control" value="${filter!}" placeholder="Search by Tag">
                <button type="submit" class="btn btn-primary ml-3">Search</button>
            </form>
        </div>
    </div>
    <a class="btn btn-primary my-2" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Add New Message
    </a>
    <div class="collapse <#if message??>show</#if>" id="collapseExample">
        <div class="form-group">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" name="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                           value="<#if message??>${message.text}</#if>" placeholder="Enter Message" >
                    <#if textError??>
                        <div class="invalid-feedback">
                            ${textError}
                        </div>
                    </#if>
                </div>
                <div class="form-group">
                    <input type="text" name="tag" class="form-control ${(tagError??)?string('is-invalid', '')}" placeholder="Tag"
                           value="<#if message??>${message.tag}</#if>">
                    <#if tagError??>
                        <div class="invalid-feedback">
                            ${tagError}
                        </div>
                    </#if>
                </div>
                <div class="form-group">
                    <div class="custom-file">
                        <input type="file" name="file" id="customFile">
                        <label class="custom-file-label" for="customFile">Choose file</label>
                    </div>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" >
                <button type="submit" class="btn btn-primary">Add</button>
            </form>
        </div>
    </div>
<#include "parts/messageEdit.ftl" />
<#include "parts/messageList.ftl" />
</@c.page>