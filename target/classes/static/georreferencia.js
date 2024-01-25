/**
 * 
 */

$('document').ready(function() {
	
	$('.table .btn-warning').on('click',function(event){
		
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$.get(href, function(georreferencia, status){
			$('#idgeorreferenciaEdit').val(georreferencia.idgeorreferencia);
			$('#latitudeEdit').val(georreferencia.latitude);
			$('#longitudeEdit').val(georreferencia.longitude);
			$('#photosEdit').val(georreferecia.photos)
			$('#descricaoEdit').val(georreferencia.descricao);
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