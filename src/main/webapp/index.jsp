<html>
<body>
<h2>Hello World!</h2>
name:<input type="text" id="name"><br>
age :<input type="text" id="age"><br>
weight:<input type="text" id="weight">
<input type="button" id="submit" value="submit">
<script src="res/js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script>
$(function(){

    $('#submit').on('click', function(){
        var name = $('#name').val();
        var age = $('#age').val();
        var weight = $('#weight').val();
        $.ajax({
            url :  "emp/save",
            type : "post",
            data : {name:name, age:age, weight:weight},
            dataType : "json",
            success : function(result){
                alert("23333");
            },
            error:function(){
               alert("66666");
            }
        });
    })

})
</script>
</body>
</html>
