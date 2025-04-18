<html>
	<head>	
		<script src="http://code.jquery.com/jquery-latest.js">		
		</script>
		<script>
			$(document).ready(function(){
				$('#btnGet').click(function () {
					console.log("aaqui GET()")
				    $.ajax({
				    	method: 'GET',
				    	url: 'empleados',
				    	success: function(data) {
				    		console.log(error);
				    	},
				    	error: function(xhr, status, error) {
				    	    console.log(error);
				    	}
				    });
			    });
			});	
			</script>
			<script>
			$(document).ready(function(){
				$('#btnPost').click(function () {
					var nombreVar = $('#nombre').val();
					var apellidoVar = $('#apellido').val();
					var rutVar = $('#rut').val();
					var cargoVar = $('#cargo').val();
					var salarioVar = $('#salario').val();
					var bonosVar = $('#bonos').val();
					var descuentosVar = $('#descuentos').val();
				    $.ajax({
				        url: 'empleados',
				        type: 'POST',
				        dataType: 'json',
				        data: {
				        	nombre : nombreVar,
							apellido: apellidoVar,
							rut: rutVar,
							cargo : cargoVar,
							salario: salarioVar,
							bonos: bonosVar,
							descuentos: descuentosVar
				        },
				        success: function(data){
				        	if(data.isValid){
				        		alert('IFFFF')
				        	}else{
				        		alert('ELSEEEEE')
				        	}		
				        }
				    });
			    });
			});		
			</script>
			<script>
			$(document).ready(function(){
				$('#btnDelete').click(function () {
					var ideVar = $('#ide').val();
					console.log(ideVar);
				    $.ajax({
				        url: 'empleados',
				        type: 'DELETE',
				        data: {
				        	ide : ideVar
				        },
				        success: function(data){
				        	if(data.isValid){
				        		alert('IFFFF')
				        	}else{
				        		alert('ELSEEEEE')
				        	}		
				        }
				    });
			    });
			});
		</script>
	</head>
	<body>
		<h2>Mostrar Empleados:</h2>	
		<form id="formMostrar">
			<input type="submit" id="btnGet" value="GET">
		</form>
		
		<h2>Agregar Empleado:</h2>	
		<form id="formAgregar">
			<input required type="text" id="nombre" placeholder="Nombre">
		    <input required type="text" id="apellido" placeholder="Apellido">
		    <input required type="text" id="rut" placeholder="Rut">
		    <input required type="text" id="cargo" placeholder="Cargo">
		    <input required type="text" id="salario" placeholder="Salario">
		    <input required type="text" id="bonos" placeholder="Bonos">
		    <input required type="text" id="descuentos" placeholder="Descuentos">
			<input type="submit" id="btnPost" value="POST">
		</form>
		
		<h2>Eliminar Empleado:</h2>	
		<form id="formEliminar">
			<input required type="text" id="ide" placeholder="ID">
			<input type="submit" id="btnDelete" value="DELETE">
		</form>
		
		<script>
			$(document).ready(function(){
				$('#btnGet').click(function () {
					console.log("aaqui GET()")
				    $.ajax({
				    	method: 'GET',
				    	url: 'empleados',
				    	success: function(data) {
				    		console.log(error);
				    	},
				    	error: function(xhr, status, error) {
				    	    console.log(error);
				    	}
				    });
			    });
			});	
		</script>
		<h2>Cargar nómina:</h2>	
		<form id="formNomina">
			<input type="file" id="fileInput">
			<input required type="text" id="ide" placeholder="ID">
			<input type="submit" id="btnCargar" value="CargarDELETE">
		</form>
		
		
		
	</body>
</html>
