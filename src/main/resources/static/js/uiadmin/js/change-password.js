function reviewAccount() {
    $.ajax({
        url: "/user/getSysUser",
        type: "GET", //请求的方式
        dataType : 'json',
        data: {
            },
        error:function (data) {
           console.log("error --> /user/getSysUser")
        },
        success:function (data) {
            if(data.state == 1){
                $("#mail").val(data.sysUser.mail);
                $("#account-id").val(data.sysUser.id);

            }else{
                return false;
            }
        }
    });
}

function save() {
    var account_id = $("#account-id").val();
    var new_password1 = $("#new-password1").val();
    var new_password2 = $("#new-password2").val();

    if(new_password1 == new_password2){
              $.ajax({
            url: "/user/changePwd",
            type: "POST", //请求的方式
            dataType : 'json',
            data: {
                "id":account_id,
                "password":new_password1
            },
            error:function (data) {

                //popup({type:'error',msg:"操作失败",delay:2000,bg:true,clickDomCancel:true});
            },
            success:function (data) {
                if(data.state == 1){

                    popup({type:'success',msg:"修改成功",delay:1000,callBack:function(){
                            //location.assign("/");
                        }});
                }else{
                    popup({type:'error',msg:"修改失败",delay:1000,bg:true,clickDomCancel:true});
                    return false;
                    //location.assign("tologin");
                }
            }
        });

    }else {
        popup({type:'error',msg:"两次输入的密码不同",delay:1000,bg:true,clickDomCancel:true});
    }

}