/**
 * 
 */

 function showDeleteConfirmationModal(bookId) {
	        // Set the book ID in the modal's delete button href
	        document.getElementById('confirmDeleteBtn').onclick = function() {
	            window.location.href = '/book/delete/' + bookId;
	        };
	
	        // Show the modal
	        $('#deleteConfirmationModal').modal('show');
	    }