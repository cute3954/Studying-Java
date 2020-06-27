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
		if (predi(val)) new_list.push(val);
	});
	return new_list;
}

// 第1引数「配列(Object)」の各値に第2引数で指定した関数を適用し、結果を配列にして返す。
function _map(list, mapper) {
	var new_list = [];
//	for (var i = 0; i < list.length; i++) {
//		new_list.push(mapper(list[i]));
//	}
	_each(list, function(val, key) {
		new_list.push(mapper(val, key));
	});
	return new_list;
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
	if (arguments.length == 2) {
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

function _is_object(obj) {
	// !!: 真偽値を反転したい、つまりtrueを返す。
	// 参照： https://www.penpale.jp/blog/double_exclamation_mark.html
	return typeof obj == 'object' && !!obj;
}

function _keys(obj) {
	return _is_object(obj) ? Object.keys(obj) : [];
}

// underscore.jsのeach()と同じ。
function _each(list, iter) {
	var keys = _keys(list);
	for (var i = 0, len = keys.length; i < len; i++) {
		iter(list[keys[i]], keys[i]);
	}
	return list;
}

var _map = _curryr(_map),
_filter = _curryr(_filter),
_values = _map(_identity);

function _identity(val) {
	return val;
}

function _pluck(data, key) {
	return _map(data, _get(key));
}

function _negate(func) {
	return function(val) {
		return !func(val);
	}
}

// filter()と真逆
var _reject = _curryr(function _reject(data, predi) {
	return _filter(data, _negate(predi));
});

// 引数配列の各値でfalseとなるものを排除した配列が返される。
var _compact = _filter(_identity);

function _find(list, predi) {
	var keys = _keys(list);
	for (var i = 0, len = keys.length; i < len; i++) {
		var val = list[keys[i]];
		if (predi(val)) return val;
	}
}

function _find_index(list, predi) {
	var keys = _keys(list);
	for (var i = 0, len = keys.length; i < len; i++) {
		if (predi(list[keys[i]])) return i;
	}
	return -1;
}

var _find = _curryr(_find),
_find_index = _curryr(_find_index);

function _some(data, predi) {
	return _find_index(data, predi || _identity) != -1;
}

function _every(data, predi) {
	return _find_index(data, _negate(predi || _identity)) == -1;
}

function _min(data) {
	return _reduce(data, function(a, b) {
		return a < b ? a : b;
	});
}

function _max(data) {
	return _reduce(data, function(a, b) {
		return a > b ? a : b;
	});
}

function _min_by(data, iter) {
	return _reduce(data, function(a, b) {
		return iter(a) < iter(b) ? a : b;
	});
}

function _max_by(data, iter) {
	return _reduce(data, function(a, b) {
		return iter(a) > iter(b) ? a : b;
	});
}

var _min_by = _curryr(_min_by),
	_max_by = _curryr(_max_by);

function _push(obj, key, val) {
	(obj[key] = obj[key] || []).push(val);
	return obj;
}

var _head = function(list) {
	return list[0];
};

var _group_by = _curryr(function(data, iter) {
	return _reduce(data, function(grouped, val) {
		return _push(grouped, iter(val), val);
	}, {});
});

var _inc = function(obj, key) {
	obj[key] ? obj[key]++ : obj[key] = 1;
	return obj;
};

var _count_by = _curryr(function(data, iter) {
	return _reduce(data, function(count, val) {
		return _inc(count, iter(val));
	}, {});
});

// 引数Objectの各キーとその値をペアにした配列を値とする入れ子の配列を返す
var _pairs = _map((val, key) => [key, val]);