    function confirmarEliminacion(clientId) {
        Swal.fire({
            title: '¿Estás seguro?',
            text: 'Esta acción eliminará el cliente',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#d33',
            cancelButtonColor: '#3085d6',
            confirmButtonText: 'Sí, eliminarlo'
        }).then((result) => {
            if (result.isConfirmed) {
                // Lógica para eliminar el cliente (puedes llamar a una función en el servidor con Ajax aquí)
                eliminarCliente(clientId);
            }
        });
    }

    function eliminarCliente(clientId) {
        // Lógica para eliminar el cliente (puedes realizar una llamada Ajax al servidor aquí)
        // Después de eliminar, podrías recargar la página o realizar alguna otra acción según tus necesidades
        Swal.fire('¡Eliminado!', 'El cliente ha sido eliminado.'+clientId, 'success').then(() => {
            // Redirige a la página o realiza alguna acción adicional
            window.location.reload(); // Recarga la página, ajusta según tus necesidades
        });
    }

