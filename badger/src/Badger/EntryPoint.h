#pragma once

#ifdef BADGER_PLATFORM_WINDOWS

    extern Badger::Application* Badger::CreateApplication();

    int main(int argc, char **argv) {
        Badger::Log::Init();

        auto app = Badger::CreateApplication();
        app->Run();
        delete app;
    }

#elif BADGER_PLATFORM_LINUX

    extern Badger::Application* Badger::CreateApplication();

    int main(int argc, char **argv) {
        Badger::Log::Init();

        auto app = Badger::CreateApplication();
        app->Run();
        delete app;
    }

#endif
