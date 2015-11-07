
$.app = {
	confirm : function(options) {
		var defaults = {
			title : "确认执行操作",
			message : "确认执行操作吗？",
			cancelTitle : '取消',
			okTitle : '确定',
			cancel : $.noop,
			ok : $.noop,
			alert : false
		};

		if (!options) {
			options = {};
		}
		options = $.extend({}, defaults, options);

		var template = '<div class="modal hide fade confirm">'
				+ '<div class="modal-header">'
				+ '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>'
				+ '<h3 class="title">{title}</h3>'
				+ '</div>'
				+ '<div class="modal-body">'
				+ '<div>{message}</div>'
				+ '</div>'
				+ '<div class="modal-footer">'
				+ '<a href="#" class="btn btn-ok btn-danger" data-dismiss="modal">{okTitle}</a>'
				+ '<a href="#" class="btn btn-cancel" data-dismiss="modal">{cancelTitle}</a>'
				+ '</div>' + '</div>';

		var modalDom = $(template.replace("{title}", options.title).replace(
				"{message}", options.message).replace("{cancelTitle}",
				options.cancelTitle).replace("{okTitle}", options.okTitle));

		var hasBtnClick = false;
		if (options.alert) {
			modalDom.find(".modal-footer > .btn-cancel").remove();
		} else {
			modalDom.find(".modal-footer > .btn-cancel").click(function() {
				hasBtnClick = true;
				options.cancel();
			});
		}
		modalDom.find(".modal-footer > .btn-ok").click(function() {
			hasBtnClick = true;
			options.ok();
		});

		var modal = modalDom.modal();

		modal.on("hidden", function() {
			modal.remove();// 移除掉 要不然 只是hidden
			if (hasBtnClick) {
				return true;
			}
			if (options.alert) {
				options.ok();
			} else {
				options.cancel();
			}
		});

		return modal;
	},
	alert : function(options) {
        if(!options) {
            options = {};
        }
        var defaults = {
            title : "警告",
            message : "非法的操作",
            okTitle : "关闭",
            ok : $.noop
        };
        options.alert = true;
        options = $.extend({}, defaults, options);
        this.confirm(options);
    },
    waiting : function(message, isSmall) {
        if(!message) {
            message = "装载中...";
        }
        message = '<img src="' + ctx + '/static/images/loading.gif" '+ (isSmall ? "width='20px'" : "") +'/> ' + message;
        if(!isSmall) {
            message = "<h4>"+message+"</h4>";
        }
        $.blockUI({
            fadeIn: 700,
            fadeOut: 700,
            showOverlay: false,
            css: {
                border: 'none',
                padding: '15px',
                backgroundColor: '#eee',
                '-webkit-border-radius': '10px',
                '-moz-border-radius': '10px',
                opacity:1,
                color: '#000',
                width: isSmall ? "40%" : "30%"

            },
            message: message
        });
    }
    ,
    waitingOver: function () {
        $.unblockUI();
    }
}


$(function() {
	$("#table tr").mouseover(function() {
		$(this).removeClass("warning").addClass("success");
	}).mouseout(function() {
		$(this).removeClass("success");
		$("#table tr:even").addClass("warning");
	});
	$("#table tr:even").addClass("warning"); // 给表格的偶数行添加class值为warning
	$("#table tr:odd").addClass(""); // 加偶数行样式
	
	
	/*删除信息确认提示*/
	$(".btn-delete").click(function() {
		var td = $(this).closest("td");
	    var url = td.data("url");
		$.app.confirm({
	        ok: function () {
	        	location.href = url;
	        }
		});
	});
	
});
