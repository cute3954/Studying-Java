// 今更ながら↓javascript関数型プログラミングについて参考となりそう
// https://qiita.com/Anders/items/25e55051893b6eaa152c

// Promiseについて
// https://qiita.com/toshihirock/items/e49b66f8685a8510bd76
function square(a) {
	// 処理成功時にはresolveが呼ばれる
	return new Promise(function(resolve) {
		setTimeout(function() {
			resolve(a * a);
		}, 500);
	});
}

//function square(a) {
//	return a * a;
//}

//square(10)
//	.then(square)
//	.then(square)
//	.then(square)
//	.then(console.log);
//
//_.go(square(10),
//	square,
//	square,
//	square,
//	console.log);

var list = [2, 3, 4];

// 命令型プログラミング
new Promise(function(resolve) {
	(function recur(res) {
		if (list.length == res.length) return resolve(res);
		square(list[res.length]).then(function(val) {
			res.push(val);
			recur(res);
		});
	})([]);
}).then(console.log);

// 関数型プログラミング
_.go(list,
	_.map(square),
	_.map(square),
	_.map(square),
	console.log
);