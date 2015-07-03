(function($) {
    $.StartScreen = function(){
        var plugin = this;

        plugin.init = function(){
            setTilesAreaSize();
            addMouseWheel();
        };

        var setTilesAreaSize = function(){
            var groups = $(".tile-group");
            var tileAreaWidth = 160;
            $.each(groups, function(i, t){
                tileAreaWidth += $(t).outerWidth()+46;
            });
            $(".tile-area").css({
                width: tileAreaWidth
            });
        };

        var addMouseWheel = function (){
            $("body").mousewheel(function(event, delta){
                var scroll_value = delta * 50;
                $(document).scrollLeft($(document).scrollLeft() - scroll_value);
                return false;
            });
        };

        plugin.init();
    }
})(jQuery);

$(function(){
    $.StartScreen();
    $("#editPassword").on('click', function(){
        $.Dialog({
            shadow: true,
            overlay: false,
            draggable: true,
            icon: '<span class="icon-unlocked"></span>',
            title: 'Draggable window',
            width: 500,
            padding: 10,
            content: 'This Window is draggable by caption.',
            onShow: function(){
                var content = '<form id="editform" action="/CRS/user/editPassword" style="width:400px; margin:40px auto; dark">' +
                           '<label style="width:100px;float:left;">&nbsp;&nbsp;&nbsp;原始密码</label>' +
                           '<div class="input-control text size4" style="float:left;"><input type="password" name="oldPwd" required><button class="btn-clear"></button></div>' +
                           '<label style="width:100px;float:left;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;新密码</label>'+
                           '<div class="input-control size4 password" style="float:left;"><input type="password" name="pwd" required><button class="btn-reveal"></button></div>' +
                           '<label style="width:100px;float:left;">   确认新密码</label>'+'</br>'+
                           '<div class="input-control size4 password" style="float:left;"><input type="password" name="comfirmpwd" required><button class="btn-reveal"></button></div>' +
                           '<div class="form-actions">' +'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
                           '<button class="button primary">确认修改</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
                           '<button class="button" type="button" onclick="$.Dialog.close()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;取消&nbsp;&nbsp;&nbsp;&nbsp&nbsp;</button> '+
                           '</div>'+
                          '</form>';

                $.Dialog.title("修改密码");
                $.Dialog.content(content);
            }
        });
    });
    $("#about").on('click', function(){
        $.Dialog({
            shadow: true,
            overlay: false,
            icon: '<span class="icon-cc"></span>',
            title: 'About',
            width: 500,
            height:240,
            padding: 10,
            content: 'Chain Repotring System</br></br>Version 1.0</br>(c) Copyright CRS, L.L.G. 2014-2015 All rights reserved.</br></br>This product includes software developed by the following</br>Echarts: <a href="http://echarts.baidu.com">http://echarts.baidu.com</a></br>JEasyUi: <a href="http://www.jeasyui.com">http://www.jeasyui.com</a>'
        });
    });
    $("#help").on('click', function(){
        $.Dialog({
            shadow: true,
            overlay: false,
            icon: '<span class="icon-phone"></span>',
            title: 'Help-Tips',
            width: 500,
            height:260,
            padding: 10,
            content: 'Are you getting into trouble?</br></br>No Problem</br>Please go to <a href="http://www.google.com">google</a> or <a href="http://www.baidu.com">baidu</a> for emergency purpose.</br></br>Perhaps you can infrom us for your convenient</br>And we will deal with it immeadiately Thanks !</br>Engineer Mr.Lin: <a href="Mr.Lin@126.com"> Mr.Lin@126.com</a></br>UI Designer Ms.Li <a href="Ms.Li@126.com"> Ms.Li@126.com</a>'
        });
    });
    
});

