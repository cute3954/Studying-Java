function _filter(list, predi) {
	var new_list = [];
//	for (var i = 0; i < users.length; i++) {
//		if (predi(users[i])) {
//			new_list.push(users[i]);
//		}
//	}
	_each(list, function(val) {
		if (predi(val)) {
			new_list.push(val);
		}
	});
	return new_list;
}

function _map(list, mapper) {
	var new_list = [];
//	for (var i = 0; i < list.length; i++) {
//		new_list.push(mapper(list[i]));
//	}
	_each(list, function(val) {
		new_list.push(mapper(val));
	});
	return new_list;
}

// underscore.jsのeach()と同じ。
function _each(list, iter) {
	for (var i = 0; i < list.length; i++) {
		iter(list[i]);
	}
	return list;
}