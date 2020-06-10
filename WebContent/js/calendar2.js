var calUtil = {
  // 当前日历显示的年份
  showYear:2019,
  // 当前日历显示的月份
  showMonth:1,
  // 当前日历显示的天数
  showDays:1,
  eventName:"load",
  
  // 初始化日历
  init:function(signList){
//	formatDate();
    calUtil.setMonthAndDay();   // 获取选定的日期
    /*if (typeof(s) == 'undefined'){
    }else{
      signList.splice('','',s);
    }*/
    calUtil.draw(signList);     // 显示日历
    calUtil.bindEnvent(signList); // 给日历绑定事件
  },
  
  
  /*formatDate:function(){
	  
  },*/
  
  // 显示日历
  draw:function(signList){
    // 绑定日历
    //alert(signList.length);
    //console.log(signList);
	  
	// 签到领取奖励
    //if(signList.length > 21){
    //  alert(21);
    //  $("#sign_note").empty();   // 移除该元素下的所有子节点和文本内容，但不会移除元素本身及属性
    //  $("#sign_note").html('<button class="sign_contener" type="button"><i class="fa fa-calendar-check-o" aria-hidden="true"></i>&nbsp;已达标，获取1次抽奖</button>');
    //}
    var str = calUtil.drawCal(calUtil.showYear,calUtil.showMonth,signList);
    $("#calendar").html(str);   // 把整个日历变成字符串，然后添加到页面视图中
    // 绑定日历表头，显示xxxx年xx月
    var calendarName=calUtil.showYear+"年"+calUtil.showMonth+"月";
    $(".calendar_month_span").html(calendarName);  
  },
  
  // 绑定事件
  bindEnvent:function(signList){
     // 绑定上个月事件
     $(".calendar_month_prev").click(function(){
    	 // ajax获取日历json数据
    //   var signList=[{"signDay":"10"},{"signDay":"11"},{"signDay":"12"},{"signDay":"13"}];
         calUtil.eventName="prev";
         calUtil.init(signList);
      });
     
     // 绑定下个月事件
      $(".calendar_month_next").click(function(){
    	  // ajax获取日历json数据
    //	  var signList=[{"signDay":"10"},{"signDay":"11"},{"signDay":"12"},{"signDay":"13"}];
    	  calUtil.eventName="next";
    	  calUtil.init(signList);
      });
    
      // 点击没有标记的日期时触发的事件
     $(".calendar_record").click(function(){
       /* ajax获取日历json数据
        alert(typeof(signList)+"yxy");
    	var signList=[{"signDay":"10"},{"signDay":"11"},{"signDay":"12"},{"signDay":"13"}];
    	var tmp = {"signDay":$(this).html()};
        if (typeof(signList) == 'undefined'){
        //不做处理
        }else{
        signList.splice('','',tmp);
        console.log(signList);
        calUtil.init(signList);
        }
        alert($(this).html());
    	var tmp = {"signDay":$(this).html()};
    	calUtil.init(signList,tmp);  */      
    });
  },
   
  // 获取当前选择的年月
  setMonthAndDay:function(){
    switch(calUtil.eventName)
    {
      case "load":   // 当前日期
        var current = new Date();   // 获取当前日期
        var year = current.getFullYear();  // 获取当前年份
        var month = current.getMonth() + 1;   // 获取当前月份
        
        calUtil.showYear=year;   // 设置当前年份  
        calUtil.showMonth=month; // 设置当前月份
        
        if (month >= 1 && month <= 9) {   // 格式化当前月份，09，12
        	calUtil.showMonth = "0" + month;
        }else{
        	calUtil.showMonth=month;  
        }        
        break;
      case "prev":   // 上个月
        var nowMonth=$(".calendar_month_span").html().split("年")[1].split("月")[0];
        var prevMonth=parseInt(nowMonth)-1;   // 获取上个月的日历
        if (prevMonth>=1 && prevMonth<=9) {
        	prevMonth="0"+prevMonth;
		}
        calUtil.showMonth=prevMonth;
        if(calUtil.showMonth==0)    // 1月之前显示上一年的最后一个月
        {
            calUtil.showMonth=12;
            calUtil.showYear-=1;
        }
        break;
      case "next":   // 下个月
        var nowMonth=$(".calendar_month_span").html().split("年")[1].split("月")[0];
        var nextMonth=parseInt(nowMonth)+1;  // 获取下个月的日历
        if (nextMonth>=1 && nextMonth<=9) {
        	nextMonth="0"+nextMonth;
		}
        calUtil.showMonth=nextMonth;
        if(calUtil.showMonth==13)   // 12月之后显示下一年的第一个月
        {
            calUtil.showMonth="01";
            calUtil.showYear+=1;
        }
        break;
    }
  },
  
  // 计算某年某个月的天数
  getDaysInmonth : function(iMonth, iYear){
   var dPrevDate = new Date(iYear, iMonth, 0);
   return dPrevDate.getDate();   
  },
  
  // 根据当前年份和月份构造日历
  bulidCal : function(iYear, iMonth) {
   var aMonth = new Array();
   aMonth[0] = new Array(7);
   aMonth[1] = new Array(7);
   aMonth[2] = new Array(7);
   aMonth[3] = new Array(7);
   aMonth[4] = new Array(7);
   aMonth[5] = new Array(7);
   aMonth[6] = new Array(7);
   var dCalDate = new Date(iYear, iMonth - 1, 1);  // 实例化某一天的日期
   var iDayOfFirst = dCalDate.getDay();  // 返回某一天所在星期的数字表示（返回值是 0（周日） 到 6（周六） 之间的一个整数）
   var iDaysInMonth = calUtil.getDaysInmonth(iMonth, iYear);  // 获取某个月的天数
   var iVarDate = 1;
   var d, w;
   aMonth[0][0] = "日";
   aMonth[0][1] = "一";
   aMonth[0][2] = "二";
   aMonth[0][3] = "三";
   aMonth[0][4] = "四";
   aMonth[0][5] = "五";
   aMonth[0][6] = "六";
   
   // 构造第一行日历
   for (d = iDayOfFirst; d < 7; d++) {    
    aMonth[1][d] = iVarDate;
    iVarDate++;
   }
   
   // 构造第二行至最后一行日历
   for (w = 2; w < 7; w++) {     // 控制行数
     for (d = 0; d < 7; d++) {   // 控制列数
       if (iVarDate <= iDaysInMonth) {
         aMonth[w][d] = iVarDate;
         iVarDate++;
       }
     }
   }
   // alert(aMonth[6][0]);
   return aMonth;
  },
  
  //  根据传过来的日期数据检验需要标记的日历日期             2019-3-27
  ifHasSigned : function(signList,day){
   var signed = false;
   $.each(signList,function(index,item){   // 遍历数组、DOM、json等，index表示当前元素的索引（下标，从0开始）
     if(item.signDate == day) {             // item表示当前元素的值
    	signed = true;
    	return false;
     }
   });
   return signed ;
  },
  
  // 根据当前年份和月份绘制日历表，并根据json数据做出标记
  drawCal : function(iYear, iMonth ,signList) {
   var myMonth = calUtil.bulidCal(iYear, iMonth);  // 构造当前月份的日历
   var htmls = new Array();   // push() 方法可向数组的末尾添加一个或多个元素，并返回新的长度。
   htmls.push("<div class='sign_main' id='sign_layer'>"); 
   htmls.push("<div class='sign_succ_calendar_title'>");
   htmls.push("<div class='calendar_month_next'>下月</div>");  // 第一行
   htmls.push("<div class='calendar_month_prev'>上月</div>");  // 第二行
   htmls.push("<div class='calendar_month_span'></div>");     // 第三行
   htmls.push("</div>");
   htmls.push("<div class='sign_equal' id='sign_cal'>");
   htmls.push("<div class='sign_row'>");
   htmls.push("<div class='th_1 bold'>" + myMonth[0][0] + "</div>");
   htmls.push("<div class='th_2 bold'>" + myMonth[0][1] + "</div>");
   htmls.push("<div class='th_3 bold'>" + myMonth[0][2] + "</div>");
   htmls.push("<div class='th_4 bold'>" + myMonth[0][3] + "</div>");
   htmls.push("<div class='th_5 bold'>" + myMonth[0][4] + "</div>");
   htmls.push("<div class='th_6 bold'>" + myMonth[0][5] + "</div>");
   htmls.push("<div class='th_7 bold'>" + myMonth[0][6] + "</div>");
   htmls.push("</div>");
   var d, w;
   for (w = 1; w < 7; w++) {
     htmls.push("<div class='sign_row'>");
     for (d = 0; d < 7; d++) {
   //  alert(calUtil.showYear+"-"+calUtil.showMonth+"-"+myMonth[2][4]);
       if (myMonth[w][d]>=1 && myMonth[w][d]<=9) {
    	   myMonth[w][d]="0"+myMonth[w][d];
       }
       var ifHasSigned = calUtil.ifHasSigned(signList,calUtil.showYear+"-"+calUtil.showMonth+"-"+myMonth[w][d]);
       //  console.log("001:"+ifHasSigned);
       if(ifHasSigned && typeof(myMonth[w][d]) != 'undefined'){
    	 // isNaN() 函数用于检查其参数是否是  非数字值(不是数字返回true,是数字返回false)。
         htmls.push("<div class='td_"+d+" on'>" + (!isNaN(myMonth[w][d]) ? myMonth[w][d] : " ") + "</div>");
       } else {
         htmls.push("<div class='td_"+d+" calendar_record'>" + (!isNaN(myMonth[w][d]) ? myMonth[w][d] : " ") + "</div>");
       }
     }
     htmls.push("</div>");
   }
   htmls.push("</div>");
   htmls.push("</div>");
   htmls.push("</div>");
   // join(separator) 方法会把数组中的所有元素放进一个字符串中，并用指定的分隔符分隔开。
   // 如果省略该参数，则默认使用逗号作为分隔符。
   return htmls.join('');  
  }
};