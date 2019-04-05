/*
 *  原创－反馈请邮件至：361899429@qq.com
 *  创建于20180426     最后修改20180626
 *  v2.1
 */
(function ($) {
    $.fn.extend({
        simplePaging: function (opts) {
            //设置默认参数
            var opt = {
                allPage: 12,//总页数
                showPage: 5,//显示页数
                startPage: 1,//第一页页码数字
                initPage: 1,//加载完毕自动跳转到第n页(初始化激活页)
                initPageClick:true,//每次页面加载完毕后，是否触发initPage页的绑定事件
                first: "首页",//首页显示字符
                last: "尾页",//尾页显示字符
                prev: "«",//上一页显示字符
                next: "»",//下一页显示字符
                showTurnTo: false,//是否显示跳转按钮，true显示，false不显示
                animateType: "animation",//过渡模式：动画“animation”、跳动“jumpy”、快速移动“fast”、正常速度移动“normal”、缓慢的速度移动“slow”、异常缓慢的速度移动“verySlow”
                animationTime: 300,//animateType为animation时，动画过渡时间(ms)
                callBack: function (num) {
                    console.log(num)
                }
            };
            //合并参数
            var option = $.extend(opt, opts);
            /*初始化激页码不能大于或小于开始页码*/
            if (option.initPage < option.startPage) {
                option.initPage = option.startPage
            } else if (option.initPage > option.startPage + option.allPage - 1) {
                option.initPage = option.startPage + option.allPage - 1
            }
            /*过渡模式跳动时间设置*/
            if (option.animateType !== "animation") {
                switch (option.animateType) {
                    case "jumpy":
                        option.animationTime = 0;
                        break;
                    case "fast":
                        option.animationTime = 100;
                        break;
                    case "normal":
                        option.animationTime = 200;
                        break;
                    case "slow":
                        option.animationTime = 400;
                        break;
                    case "verySlow":
                        option.animationTime = 800;
                        break;
                }
            }
            /*显示页至少有1页，并且不能大于总页数*/
            option.showPage <= 0 ? option.showPage = 1 : option.showPage;
            option.showPage > option.allPage ? option.showPage = option.allPage : option.showPage;
            /***************/
            var dialog = {};
            var simplePaging = $(this);
            var spPrev = $("<div class='spPrev'>");
            var spFirst = $("<div class='spFirst'>");
            var spPage = $("<div class='spPage'>");
            var spCover = $("<div class='spCover'>");
            var spActiveBg = $("<div class='spActiveBg'>");
            var spLast = $("<div class='spLast'>");
            var spNext = $("<div class='spNext'>");
            var spTurnTo = $("<div class='spTurnTo'>");
            var ul = $("<ul>");
            var delay = false;//延时，不用修改，此项用于前一个点击未完全执行时，阻止其它事件触发
            var init = true;//是否初始化加载页面
            var centerShowPage;
            if (option.showPage % 2 === 0) {
                centerShowPage = Math.floor((option.showPage - 1) / 2)
            } else {
                centerShowPage = Math.floor(option.showPage / 2)
            }
            /*程序开始*/
            dialog.init = function () {
                //插件页码
                ul.append(spActiveBg);
                for (var i = 0, j = option.startPage; i < option.allPage; i++, j++) {
                    var li = $("<li>");
                    li.html("<p>" + j + "</p>").on("click", function () {
                        if (!delay) {
                            changePage($(this).text())
                        }
                    });
                    ul.append(li)
                }
                //上一页
                spPrev.text(option.prev).on("click", function () {
                    if (!delay) {
                        var num = ul.find("li.active").text() - 1;
                        changePage(num)
                    }
                });
                //首页
                spFirst.text(option.first).on("click", function () {
                    if (!delay) {
                        var num = ul.find("li:first").text();
                        changePage(num)
                    }
                });
                //尾页
                spLast.text(option.last).on("click", function () {
                    if (!delay) {
                        var num = ul.find("li:last").text();
                        changePage(num)
                    }
                });
                //下一页
                spNext.text(option.next).on("click", function () {
                    if (!delay) {
                        var num = ul.find("li.active").text() - 0 + 1;
                        changePage(num)
                    }
                });
                spCover.append(ul);
                spPage.append(spCover);
                simplePaging.append(spPrev, spFirst, spPage, spLast, spNext);
                spCover.width(ul.find("li").outerWidth(true) * option.showPage);//页码中间宽度
                ul.width(ul.find("li").outerWidth(true) * option.allPage).find("li").eq(option.initPage - option.startPage).trigger("click");//页码总宽度
                //显示跳转
                if (option.showTurnTo) {
                    var input = $("<input type='text'>");
                    var btn = $("<div class='btn'>");
                    var spTurnToAllPageTip = $("<div class='spTurnToAllPageTip'>");
                    input.val(option.startPage).change(function () {
                        var num = $(this).val();
                        num > (option.allPage + option.startPage - 1) ? num = (option.allPage + option.startPage - 1) : num;
                        num <= option.startPage ? num = option.startPage : num;
                        $(this).val(num);
                    });
                    btn.text("跳转").on("click", function () {
                        if (!delay) {
                            var num = input.val();
                            changePage(num)
                        }
                    });
                    $(document).keyup(function (event) {
                        var e = event || window.event;
                        var k = e.keyCode || e.which;
                        if (k == 13 && input.is(":focus")) {
                            btn.trigger("click");
                            input.blur();
                        }
                    });
                    spTurnToAllPageTip.text("共" + (option.allPage + option.startPage - 1) + "页");
                    spTurnTo.append(input, btn, spTurnToAllPageTip);
                    simplePaging.append(spTurnTo).width(ul.find("li").outerWidth(true) * (option.showPage + 6) + 15);
                } else {
                    simplePaging.width(ul.find("li").outerWidth(true) * (option.showPage + 4));
                }
            };
            /*改变页码函数*/
            function changePage(num) {
                if (num < option.startPage || num > option.allPage + option.startPage - 1) {
                    return false;
                } else if (ul.find("li.active").text() == num&&!init) {
                    return false;
                } else if (isNaN(num)) {
                    return false;
                }
                delay = !delay;
                num = Number(num);
                var leng = num - option.startPage;
                var liWidth = ul.find("li").outerWidth(true);
                ul.find("li.active").removeClass("active");
                spActiveBg.animate({"left": liWidth * (num - option.startPage)}, option.animationTime);
                if (leng <= centerShowPage) {
                    ul.animate({"left": 0}, option.animationTime, function () {
                        autoActive()
                    });
                } else if (leng >= option.allPage - centerShowPage - 1) {
                    ul.animate({"left": -liWidth * (option.allPage - option.showPage)}, option.animationTime, function () {
                        autoActive()
                    });
                } else {
                    ul.animate({"left": -liWidth * (leng - centerShowPage)}, option.animationTime, function () {
                        autoActive()
                    });
                }
                function autoActive() {
                    delay = !delay;
                    ul.find("li").eq(num - option.startPage).addClass("active");
                    if(init){
                        init = false;
                        if(option.initPageClick){
                            option.callBack(num);
                        }
                    }else {
                        option.callBack(num);
                    }
                }
            }
            dialog.init();
        }
    });
})(jQuery);