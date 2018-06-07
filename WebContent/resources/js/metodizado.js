function startLoader(){
			PF('_dlgLoader').show();
		}
		
		function endLoader(){
			PF('_dlgLoader').hide();
		}
		
		
		
			
		function validar(xhr, status, args) {
			if (!args.esValido) {
				jQuery('#dlgDetNuevo').effect("shake", {
					times : 1
				}, 100);
			} else {
				//limpiando
				dlgNuevo.hide();
				console.log("cerro")
			}
		}
		
		function imprimirCargo() {
				document.getElementById("tab:cuadroPosicion:btl").update();
		}

		function cambiarValor(){
			console.log("entro");
			var elemento = document.querySelector('#xpruebax');
			elemento.setAttribute("color", "blue");
		}