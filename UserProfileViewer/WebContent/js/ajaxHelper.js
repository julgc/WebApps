	/*
	 *ajax call pUrl->the url; pform->form to submit;
	 *target-> target cointainer;
	 *callback->function() to call after ajax success
	 */
	function execAjaxCall(pUrl, pform, pReqtype, target, callback) {
		var vData;
		if (pform != null)
			try {
				vData = pform.serialize();
			} catch (err) {
				vData = null;
			}
		$.ajax({
			url : pUrl,
			success : function(result) {
				if (target != null) {
					target.html(result);
				}
				if (callback != null) {
					callback();
				}
			},
			error : (function(jqXHR, textStatus, thrownError) {
				target.html("Error " + jqXHR.status);
			}),
			data : vData,
			type : pReqtype
		});
	}