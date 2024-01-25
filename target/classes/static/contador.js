/**
 * 
 */

$('document').ready(function() {
	
	$('.table .btn-warning').on('click',function(event){
		
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$.get(href, function(contador, status){
			$('#IdcontadorEdit').val(contador.idcontador);
			$('#conta_numeroEdit').val(contador.conta_numero);
			$('#numero_contadorEdit').val(contador.numero_contador);
			$('#leitura_anteriorEdit').val(contador.leitura_anterior);
			$('#nova_leituraEdit').val(contador.nova_leitura);
			$('#ramalEdit').val(contador.ramal);
			$('#amperagemEdit').val(contador.amperagem);
			$('#latitudeEdit').val(contador.latitude);
			$('#longitudeEdit').val(contador.longitude);
			
			$('#cidadeEdit').val(contador.cidade);
			$('#distritoEdit').val(contador.distrito);
			$('#clienteEdit').val(cliente.idcliente);
			$('#descricaoEdit').val(contador.descricao);

		});	
		
		$('#editModal').modal();
		
	});
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();
		
	});
});