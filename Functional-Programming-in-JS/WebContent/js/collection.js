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