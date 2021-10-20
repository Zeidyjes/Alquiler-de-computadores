$(document).ready(function(){
    $("#btnUpdate").hide();
    $("#btnUpdate2").hide();
    $("#btnUpdate3").hide();

})
function acciones(tipo,num,numid){
if(num==1){
    direccion="https://gc595847a1c6c3e-computer.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/computer/computer"
    if(tipo == 'agregar' ){
        var datos = {
            id: $("#numID").val(),
            brand: $("#marca").val(),
            model: $("#modelo").val(),
            category_id: $("#categoria").val(),
            name: $("#nombre").val()   
    }
    agregar(datos,direccion,num)
    }
    if(tipo == 'listar'){
        listar(direccion,num)
    }
    if(tipo == 'borrar'){
        var datos={
            id:numid
        }
        borrar(direccion,datos,num);
    }
    if(tipo == 'editar'){
        $("#btnGuardar").hide();
        $("#btnUpdate").show();
        $("#btnListar").hide();
        $("#numID").prop('disabled',true);
        $("#marca").focus();
        editar(direccion,numid,num);
       
    }
    if(tipo == 'actualizar'){
        var datos = {
        id: $("#numID").val(),
        brand: $("#marca").val(),
        model: $("#modelo").val(),
        category_id: $("#categoria").val(),
        name: $("#nombre").val()}
       actualizar(direccion,datos,num);
       console.log(direccion);

    }
    
}
if(num==2){
    direccion="https://gc595847a1c6c3e-computer.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/client/client"
    if(tipo == 'agregar' ){
        var datos = {
            id: $("#numerID").val(),
            name: $("#Nom_cliente").val(),
            email: $("#Correo").val(),
            age: $("#años").val(),   
    }
    agregar(datos,direccion,num)
    }
    if(tipo == 'listar'){
        listar(direccion,num)
    }
    if(tipo == 'borrar'){
        var datos={
            id:numid
        }
        borrar(direccion,datos,num);
    }
    if(tipo == 'editar'){
        $("#btnGuardar2").hide();
        $("#btnUpdate2").show();
        $("#btnListar2").hide();
        $("#numerID").prop('disabled',true);
        $("#Nom_cliente").focus();
        editar(direccion,numid,num);    
       
    }
    if(tipo == 'actualizar'){
        var datos = {
        id: $("#numerID").val(),
        name: $("#Nom_cliente").val(),
        email: $("#Correo").val(),
        age: $("#años").val()}
       actualizar(direccion,datos,num);
       console.log(datos);

    }
}
if(num==3){
    direccion="https://gc595847a1c6c3e-computer.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/message/message"
    if(tipo == 'agregar' ){
        var datos = {
            id: $("#mesageID").val(),
            messagetext: $("#mensaje").val(),  
    }
    agregar(datos,direccion,num)
    }
    if(tipo == 'listar'){
        listar(direccion,num)
    }
    if(tipo == 'borrar'){
        var datos={
            id:numid
        }
        borrar(direccion,datos,num);
    }
    if(tipo == 'editar'){
        $("#btnGuardar3,#btnListar3").hide();
        $("#btnUpdate3").show();
        $("#mesageID").prop('disabled',true);
        $("#mensaje").focus();
        editar(direccion,numid,num);    
    }
    if(tipo == 'actualizar'){
        var datos = {
        id: $("#numerID").val(),
        messagetext: $("#mensaje").val()}
       actualizar(direccion,datos,num);
       console.log(datos);

    }
}
}

function agregar(datos,direccion,num) {
   
    
    let datosPeticion = JSON.stringify(datos);

    $.ajax({
        url: direccion,
        data: datosPeticion,
        type: 'POST',
        contentType: "application/JSON",

        success: function (respuesta) {
            console.log(respuesta);
            listar(direccion,num);
            
        },
        error: function (xhr, status) {
            console.log(status);
        }
    });
    habilitar();

}
function listar(direccion,num) {
    $.ajax({
        url:direccion,
        type: 'GET',
        dataType: 'json',

        success: function (respuesta) {
            console.log(respuesta,num);
            listartabla(respuesta.items,num);

        },
        error: function (xhr, status) {
            console.log(status);
        }
    });

}

function listartabla(valores,num) {
    var llaves = valores[0];
    titulo =Object.keys(llaves)
    console.log(titulo)
     if (num==1){
    var tabla = `<table>
    <TR>`
    titulo.forEach(element => {
        tabla+="<th>"+element+"</th>"
        
    });

    tabla+='<th colspan="2">ACCIONES</th>  </TR>';
            // <th>ID</th>
            // <th>MARCA</th>
            // <th>MODEL0</th>
            // <th>CATEGORIA</th>
            // <th>NOMBRE</th>
            // 
           
           
            // ;
    valores.forEach(element => {
        tabla += `<tr>
                <td>${element.id}</td>
                <td>${element.brand}</td>
                <td>${element.model}</td>
                <td>${element.category_id}</td>
                <td>${element.name}</td>
                <td><button onclick="acciones('editar',1,${element.id})">editar</button></td>
                <td><button onclick="acciones('borrar',1,${element.id})">eliminar</button></td>
                </tr>`;

    });
    tabla += `</table>`
    $("#listacomputador").html(tabla)}
    if(num==2){
        var tabla = `<table>
            <TR>
            <th>ID</th>
            <th>NOMBRE</th>
            <th>EMAIL</th>
            <th>EDAD</th>
            <th colspan="2">ACCIONES</th>   
            </TR>`;
        valores.forEach(element => {
        tabla += `<tr>
                <td>${element.id}</td>
                <td>${element.name}</td>
                <td>${element.email}</td>
                <td>${element.age}</td>
                <td><button onclick="acciones('editar',2,${element.id})">editar</button></td>
                <td><button onclick="acciones('borrar',2,${element.id})">eliminar</button></td>
                </tr>`;
            });
        tabla += `</table>`
        $("#listacliente").html(tabla)}
        if(num==3){
         var tabla = `<table>
         <TR>
         <th>ID</th>
         <th>MENSAJE</th>
         <th colspan="2">ACCIONES</th>   
         </TR>`;
     valores.forEach(element => {
     tabla += `<tr>
             <td>${element.id}</td>
             <td>${element.messagetext}</td>
             <td><button onclick="acciones('editar',3,${element.id})">editar</button></td>
             <td><button onclick="acciones('borrar',3,${element.id})">eliminar</button></td>
             </tr>`;
         });
     tabla += `</table>`
     $("#listamensaje").html(tabla)}
          


        }

function borrar(direccion,datos,num) {
    let datosPeticion = JSON.stringify(datos);

    $.ajax({
        url: direccion,
        data: datosPeticion,
        type: 'DELETE',
        contentType: "application/JSON",

        success: function (respuesta) {
            console.log("BORRADO");
            listar(direccion,num);

        },
        error: function (xhr, status) {
            console.log(status);
        }
    });
}

function editar(direccion,numID,num){
    $.ajax({
        url: direccion+"/"+numID,
        type: 'GET',
        dataType:'json',

        success: function (respuesta) {
            var valores = respuesta.items;
            console.log(direccion);
            cargarDatos(valores,num);
        },
        error: function (xhr, status) {
            console.log(status);
            console.log(direccion);
        }
    });
}
function actualizar(direccion,datos,num){
    let datosPeticion = JSON.stringify(datos);

    $.ajax({
        url:direccion,
        data:datosPeticion,
        type:'PUT',
        contentType:"application/JSON",

        success: function (respuesta) {
            console.log("Actualizado");
            listar(direccion,num);
        },
        error: function (xhr, status) {
            console.log(status);
            
        }
    });
    habilitar();
    
}
function habilitar(){
    $("#btnGuardar,#btnGuardar2,#btnGuardar3").show();
    $("#btnUpdate,#btnUpdate2,#btnUpdate3").hide();
    $("#btnListar,#btnListar2,#btnListar3").show();
    $("#numID,#numerID,#mesageID").prop('disabled',false);
    $("#numID,#Nom_cliente",).val(""),
    $("#marca,#Correo").val(""),
    $("#modelo,#años").val(""),
    $("#categoria,#numerID").val(""),
    $("#nombre,#mensaje,#mesageID").val("");
}
function cargarDatos(valores,num){
    if(num==1){
      $("#numID").val(valores[0].id);
      $("#marca").val(valores[0].brand);
      $("#modelo").val(valores[0].model);
      $("#categoria").val(valores[0].category_id);
      $("#nombre").val(valores[0].name);
    }
    if(num==2){
    $("#numerID").val(valores[0].id);
    $("#Nom_cliente").val(valores[0].name);
    $("#Correo").val(valores[0].email);
    $("#años").val(valores[0].age);
     }
     if(num==3){
        $("#mesageID").val(valores[0].id);
        $("#mensaje").val(valores[0].messagetext);
         }

}