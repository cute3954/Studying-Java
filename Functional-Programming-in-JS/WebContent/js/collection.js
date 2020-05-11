// コレクション中心プログラミング
// 処理を行うために一貫性のある語彙を確立し、包括的に揃えた関数を再利用できるようにすること

// 1. 収集する：　map, values, pluck等
// 2. フィルターする：　filter, reject, compact, without等
// 3. 見つける：　find, some, every等
// 4. 折る：　reduce, min, max, group_by, count_by

var users = [
	{ id: 10, name: 'ID', age: 36 },
	{ id: 20, name: 'BJ', age: 32 },
	{ id: 30, name: 'JM', age: 32 },
	{ id: 40, name: 'PJ', age: 27 },
	{ id: 50, name: 'HA', age: 25 },
	{ id: 60, name: 'JE', age: 26 },
	{ id: 70, name: 'JI', age: 31 },
	{ id: 80, name: 'MP', age: 23 },
	{ id: 90, name: 'FP', age: 13 }
];

// 1. 収集する：　map
// 	1) values
console.log(_values(users[0]));
//	2) pluck
console.log(_pluck(users, 'age'));
console.log(_pluck(users, 'name'));
console.log(_pluck(users, 'id'));

// 2. フィルターする：　filter
console.log(
	_filter(users, function(user) {
		return user.age > 30;
	})
);
//	1) reject
console.log(
	_reject(users, function(user) {
		return user.age > 30;
	})
);
//	2) compact
console.log(_compact([1, 2, 0, false, null, {}]));

console.clear();

// 3. 見つける：　find, find_index
console.log(
	_get(_find(users, function(user) {
		return user.age < 30;
	}), 'name')
);
_go(users,
	_find(function(user) { return user.id > 30; }),
	_get('name'),
	console.log
);
console.log(
	_find_index(users, function(user) {
		return user.id == 50;
	})
);
// 	1) some
console.log(
	_some([1, 2, 5, 10, 20], function(val) {
		return val > 10;
	})
);
console.log(
	_some([1, 2, 5, 10, 20], function(val) {
		return val > 20;
	})
);
// 第2引数省略
// true
console.log(
	_some([1, 2, 0, 10])
);
// false
console.log(
	_some([null, false, 0])
);

console.log(
	_some(users, function(user) {
		return user.age < 20;
	})
);

//	2) every
console.log(
	_every([1, 2, 5, 10, 20], function(val) {
		return val > 10;
	})
);
console.log(
	_every([12, 24, 5, 10, 20], function(val) {
		return val > 3;
	})
);
// 第2引数省略
// false
console.log(
	_every([null, false, 1])
);
// true
console.log(
	_every([1, 2, 10])
);