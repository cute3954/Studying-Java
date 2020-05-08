// ↓　LodashとUnderscoreは必要ないかも。後程読んでみよう
// https://qiita.com/ossan-engineer/items/ad5313d84da82c6ac421

// 第1引数「配列(Object)の値の中で第2引数の関数の条件を満たしている値のみの配列を返す。
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

// 第1引数「配列(Object)」の各値に第2引数で指定した関数を適用し、結果を配列にして返す。
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

// カリー化について -> https://qiita.com/KtheS/items/1a93ba0a6d722a534439
// カリー化したメソッド
function _curry(fn) {
	return function(a, b) {
		return arguments.length == 2 ? fn(a, b) : function(b) {return fn(a, b);}; 
	}
}
// 右からカリー化
function _curryr(fn) {
	return function(a, b) {
		return arguments.length == 2 ? fn(a, b) : function(b) {return fn(b, a);}; 
	}
}

var _get = _curryr(function(obj, key) {
	return obj == null ? undefined : obj[key];
});

var slice = Array.prototype.slice;

// 第1引数「配列」のindex値 = 0から第2引数の数までの値が削除され、残りの配列が返される。
// 第1引数のみの時は、最初のindex値が削除され残りが返る。
// ただのslice()じゃなくslice.callを使っているため、第1引数にObjectを入れても問題はないと思う。
function _rest(list, num) {
	return slice.call(list, num || 1);
}

// 第1引数「配列（Object）」の前の値をメモ化して現在のindexの値と共に第2引数の関数に渡し各値を処理。
// 累積処理される。
function _reduce(list, iter, memo = 0) {
	// 引数が3未満なら配列の最初の値をメモする。
	if (arguments.lenght == 2) {
		memo = list[0];
		list = _rest(list);
	}
	_each(list, function(val) {
		memo = iter(memo, val);
	})
	return memo;
}

function _go(arg) {
	var fns = _rest(arguments);
	return _pipe.apply(null, fns)(arg);
}

// 関数合成
// こちらを参考 -> https://qiita.com/jlkiri/items/5aa539ee74be2cc99409
function _pipe() {
	var fns = arguments;
	return function(arg) {
		return _reduce(fns, function(arg, fn) {
			return fn(arg);
		}, arg);
	};
}
