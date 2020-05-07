var users = [
	{id: 1, name: 'ID', age: 36},
	{id: 2, name: 'BJ', age: 32},
	{id: 3, name: 'JM', age: 32},
	{id: 4, name: 'PJ', age: 27},
	{id: 5, name: 'HA', age: 25},
	{id: 6, name: 'JE', age: 26},
	{id: 7, name: 'JI', age: 31},
	{id: 8, name: 'MP', age: 23}
];

/* 1. 命令型プログラミング */
// 1)　30歳以上のメンバーのみを絞り込んで配列に格納
var temp_users = [];
for (var i = 0; i < users.length; i++) {
	if (users[i].age >= 30) {
		temp_users.push(users[i]);
	}
}
console.log(temp_users);

// 2)　30歳以上のメンバーのnameを格納
var names = [];
for (var i = 0; i < temp_users.length; i++) {
	names.push(temp_users[i].name);
}
console.log(names);

// 3)　30歳未満のメンバーのみを絞り込んで配列に格納
var temp_users = [];
for (var i = 0; i < users.length; i++) {
	if (users[i].age < 30) {
		temp_users.push(users[i]);
	}
}
console.log(temp_users); 

// 4)　30歳未満のメンバーのageを格納
var ages = [];
for (var i = 0; i < temp_users.length; i++) {
	ages.push(temp_users[i].age);
}
console.log(ages);

/* 2. 関数型プログラミング */
// underscore.jsのfilter()、map()と同じ。
// 1)_filter
var over_30 = _filter(users, function(user) {return user.age >= 30;});
console.log(over_30);
var under_30 = _filter(users, function(user) {return user.age < 30;});
console.log(under_30);

// 2)_map
var names = _map(over_30, function(user) {
	return user.name;
})
console.log(names);
var ages = _map(under_30, function(user) {
	return user.age;
})
console.log(ages);
