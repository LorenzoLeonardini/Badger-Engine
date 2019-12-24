#pragma once

#include "Core.h"
#include "spdlog/spdlog.h"
#include "spdlog/fmt/ostr.h"

namespace Badger {

    class BADGER_API Log {
    private:
        static std::shared_ptr<spdlog::logger> s_CoreLogger;
        static std::shared_ptr<spdlog::logger> s_ClientLogger;
    public:
        static void Init();

        inline static std::shared_ptr<spdlog::logger>& GetCoreLogger() { return s_CoreLogger; }
        inline static std::shared_ptr<spdlog::logger>& GetClientLogger() { return s_ClientLogger; }
    };

}

// Core log macros
#define BADGER_CORE_TRACE(...)    ::Badger::Log::GetCoreLogger()->trace(__VA_ARGS__)
#define BADGER_CORE_INFO(...)     ::Badger::Log::GetCoreLogger()->info(__VA_ARGS__)
#define BADGER_CORE_WARN(...)     ::Badger::Log::GetCoreLogger()->warn(__VA_ARGS__)
#define BADGER_CORE_ERROR(...)    ::Badger::Log::GetCoreLogger()->error(__VA_ARGS__)
#define BADGER_CORE_FATAL(...)    ::Badger::Log::GetCoreLogger()->fatal(__VA_ARGS__)

// Client log macros
#define BADGER_TRACE(...)         ::Badger::Log::GetClientLogger()->trace(__VA_ARGS__)
#define BADGER_INFO(...)          ::Badger::Log::GetClientLogger()->info(__VA_ARGS__)
#define BADGER_WARN(...)          ::Badger::Log::GetClientLogger()->warn(__VA_ARGS__)
#define BADGER_ERROR(...)         ::Badger::Log::GetClientLogger()->error(__VA_ARGS__)
#define BADGER_FATAL(...)         ::Badger::Log::GetClientLogger()->fatal(__VA_ARGS__)
