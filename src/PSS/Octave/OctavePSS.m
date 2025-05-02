>> x = 0 : 50;
>> y = x.^2;
>> plot(y);
>> saltValue = randi([-300, 300], size(y));
>> y = y + saltValue;
>> plot(x, y);
>> windowValue = 5;
>> for i = 1 : length(y)
left = max(1, i - windowValue);
right = min(length(y), i + windowValue);
y(i) = mean(y(left : right));
end
>> plot(x, y);