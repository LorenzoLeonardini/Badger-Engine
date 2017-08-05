#pragma once

#include <string>
#include <sstream>
#include <vector>

namespace badger {
	
	static std::vector<std::string> split_string(const std::string& string, const char delimiter)
	{
		size_t start = 0;
		size_t end = string.find_first_of(delimiter);

		std::vector<std::string> result;

		while (end <= std::string::npos)
		{
			result.emplace_back(string.substr(start, end - start));

			if (end == std::string::npos)
				break;

			start = end + 1;
			end = string.find_first_of(delimiter, start);
		}

		return result;
	}

}