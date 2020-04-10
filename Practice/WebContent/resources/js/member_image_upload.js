$(function(){
	// 画像ファイルプレビュー表示のイベント追加
	$('#_uploadImage').change(function(e) {
		if (e.target.files[0]) {
			var file = e.target.files[0],
				reader = new FileReader(),
				$preview = $('#_previewArea');
			
			
			// 画像ファイル以外の場合は何もしない
			if (file.type.indexOf("image") < 0) {
				return false;
			}
			
			// ファイル読み込みが完了した際のイベント登録
			reader.onload = (function(file) {
				return function(e) {
					// 既存のプレビューを削除
					$preview.empty();
					// #_previewAreaの領域の中にロードした画像を表示するimageタグを追加
					$preview.append($('<img>').attr({
						src: e.target.result,
						width: "250px",
						id: "_previewImage"
						}));
				}	
			})(file);
			reader.readAsDataURL(file);
		}
	});
});