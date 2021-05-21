<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>${errMsg}</div>
<div>
    <div>
        <a href="login">login 화면</a>
    </div>

    <form id="frm">
        <div><input type="text" name="uid" placeholder="id"></div>
        <div><input type="password" name="upw" placeholder="password"></div>
        <div><input type="text" name="unm" placeholder="name"></div>
        <div>
            성별 :
            <label>여성 <input type="radio" name="gender" value="0" checked></label>
            <label>남성 <input type="radio" name="gender" value="1"></label>
        </div>
    </form>

    <input type="button" value="회원가입" onclick="join();">

    <script>
        function join(){
            var frmElm = document.querySelector('#frm');
            var uid = frmElm.uid.value;
            var upw = frmElm.upw.value;
            var unm = frmElm.unm.value;
            var gender = frmElm.gender.value;

            var param = {uid, upw, unm, gender}

            ajax(param);
        }
        function ajax(param){
            console.log("ajax 실행!")
            const init = {
                method:'POST',
                headers:{
                    'Content-Type':'application/json'
                },
                body: JSON.stringify(param)
            }
            // 이걸 통해서 서블릿(컨트롤)로 신호를 날리는 건가??
            // json to json
            fetch('/user/join',init) // 보내기
            .then(response => response.json()) // 다시 받아오기
            .then(myJson => {
                console.log(myJson);
                console.log(myJson.uid);
            });

        }

    </script>

</div>